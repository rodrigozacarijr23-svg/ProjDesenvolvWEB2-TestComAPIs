package org.example.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planilha {

    @Id
    private String id;
    @NotEmpty
    private String nomePlanilha;
    @NotEmpty
    private Double tamanhoArquivo;
    @NotEmpty
    private int qtdLinhas;
    @NotEmpty
    private int qtdColunas;
    @NotEmpty
    private Usuario usuarioCadastrado;
    @NotEmpty
    private boolean status;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomePlanilha() {
        return nomePlanilha;
    }
    public void setNomePlanilha(String nomePlanilha) {
        this.nomePlanilha = nomePlanilha;
    }
    public Double getTamanhoArquivo() {
        return tamanhoArquivo;
    }
    public void setTamanhoArquivo(Double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    public int getQtdLinhas() {
        return qtdLinhas;
    }
    public void setQtdLinhas(int qtdLinhas) {
        this.qtdLinhas = qtdLinhas;
    }
    public int getQtdColunas() {
        return qtdColunas;
    }
    public void setQtdColunas(int qtdColunas) {
        this.qtdColunas = qtdColunas;
    }
    public Usuario getUsuarioCadastrado() {
        return usuarioCadastrado;
    }
    public void setUsuarioCadastrado(Usuario usuarioCadastrado) {
        this.usuarioCadastrado = usuarioCadastrado;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}
