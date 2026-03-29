package org.example.service;

import java.time.LocalDate;
import java.util.List;

import org.example.model.ComparacaoPlanilha;
import org.example.model.Planilha;
import org.example.model.ScoreComparacao;
import org.example.model.HistoricoComparacaoPlanilhas;
import org.example.repository.ComparacaoPlanilhaRepository;
import org.example.repository.HistoricoComparacaoPlanilhasRepository;
import org.example.repository.ScoreComparacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ComparacaoPlanilhaService {

    @Autowired
    private ComparacaoPlanilhaRepository comparacaoPlanilhaRepository;

    @Autowired
    private ScoreComparacaoRepository scoreRepository;

    @Autowired
    private HistoricoComparacaoPlanilhasRepository historicoRepository;

    @Autowired
    private PlanilhaService planilhaService; // ou client

    public ComparacaoPlanilha save(ComparacaoPlanilha comparacao){

        // 🔎 Buscar planilhas completas
        Planilha p1 = planilhaService.findById(comparacao.getPlanilhaInicial().getId());
        Planilha p2 = planilhaService.findById(comparacao.getPlanilhaComparacao().getId());
        comparacao.setPlanilhaInicial(p1);
        comparacao.setPlanilhaComparacao(p2);

        // 🧠 Gerar score automaticamente
        int diffLinhas = Math.abs(p1.getQtdLinhas() - p2.getQtdLinhas());
        int diffColunas = Math.abs(p1.getQtdColunas() - p2.getQtdColunas());

        int valorScore = 100 - (diffLinhas + diffColunas);
        if(valorScore < 0) valorScore = 0;

        ScoreComparacao score = new ScoreComparacao();
        score.setScore(valorScore);

        if(valorScore > 80){
            score.setDescricao("Alta similaridade");
        } else if(valorScore > 50){
            score.setDescricao("Média similaridade");
        } else {
            score.setDescricao("Baixa similaridade");
        }

        // 💾 Salvar score separado (como professor pediu)
        score = scoreRepository.save(score);

        // 🔗 Vincular score na comparação
        comparacao.setScoreComparacao(score);

        // 📅 Data automática
        comparacao.setData(LocalDate.now());

        // 💾 Salvar comparação
        ComparacaoPlanilha salva = comparacaoPlanilhaRepository.save(comparacao);

        // 🗂 Criar histórico
        HistoricoComparacaoPlanilhas historico = new HistoricoComparacaoPlanilhas();
        historico.setComparacaoPlanilha(salva);
        historico.setData(LocalDate.now());

        historicoRepository.save(historico);

        return salva;
    }

    public List<ComparacaoPlanilha> findAll(){
        return comparacaoPlanilhaRepository.findAll();
    }

    public ComparacaoPlanilha findById(String id){
        return comparacaoPlanilhaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ComparacaoPlanilha not found"));
    }
}
