package org.example.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class HistoricoComparacaoPlanilhas {

    @Id
    private String id;
    @NotEmpty
    private ComparacaoPlanilha comparacaoPlanilha;
    @NotEmpty
    private LocalDate data;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ComparacaoPlanilha getComparacaoPlanilha() {
        return comparacaoPlanilha;
    }
    public void setComparacaoPlanilha(ComparacaoPlanilha comparacaoPlanilha) {
        this.comparacaoPlanilha = comparacaoPlanilha;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
}
