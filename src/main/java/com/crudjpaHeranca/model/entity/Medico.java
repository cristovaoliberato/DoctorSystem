package com.crudjpaHeranca.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
@DiscriminatorValue("M")
public class Medico extends Pessoa {

    @NotBlank(message = "Campo não pode ser vazio")
    private String crm;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.REMOVE)
    private List<Consulta> consultas;
    @OneToOne
    private Agenda agenda;
    @ManyToMany
    @JoinTable(
            name = "medico_especialidade",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private List<Especialidade> especialidades;
    public String getCrm() {
        return crm;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
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

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
}
