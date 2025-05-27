package com.ati.backend.model;

import jakarta.persistence.*;

@Entity
public class Pat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cod;
    private Boolean disponibil;
    private String tip;

    @ManyToOne
    @JoinColumn(name = "spital_id")
    private Spital spital;

    // Getteri și setteri
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Boolean getDisponibil() {
        return disponibil;
    }

    public void setDisponibil(Boolean disponibil) {
        this.disponibil = disponibil;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Spital getSpital() {
        return spital;
    }

    public void setSpital(Spital spital) {
        this.spital = spital;
    }
}
