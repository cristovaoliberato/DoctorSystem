package com.crudjpaHeranca.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@DiscriminatorValue("M")
public class Medico extends Pessoa {

    @NotBlank(message = "Campo não pode ser vazio")
    private String crm;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.REMOVE)
    private List<Consulta> consultas;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
