package org.example.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ComparacaoPlanilha {

    @Id
    private String id;
    @NotEmpty
    private Planilha planilhaInicial;
    @NotEmpty
    private Planilha planilhaComparacao;
    @NotEmpty
    private String descricao;
    @NotEmpty
    private boolean status;
    @NotEmpty
    private ScoreComparacao scoreComparacao;
    @NotEmpty
    private String data;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Planilha getPlanilhaInicial() {
        return planilhaInicial;
    }
    public void setPlanilhaInicial(Planilha planilhaInicial) {
        this.planilhaInicial = planilhaInicial;
    }
    public Planilha getPlanilhaComparacao() {
        return planilhaComparacao;
    }
    public void setPlanilhaComparacao(Planilha planilhaComparacao) {
        this.planilhaComparacao = planilhaComparacao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public ScoreComparacao getScoreComparacao() {
        return scoreComparacao;
    }
    public void setScoreComparacao(ScoreComparacao scoreComparacao) {
        this.scoreComparacao = scoreComparacao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

}
