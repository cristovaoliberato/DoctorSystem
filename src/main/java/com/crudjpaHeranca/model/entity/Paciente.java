package com.crudjpaHeranca.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@DiscriminatorValue("P")
public class Paciente extends Pessoa
{
    @NotBlank(message = "Campo não pode ser vazio")
    private String telefone;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    private List<Consulta> consultas;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
