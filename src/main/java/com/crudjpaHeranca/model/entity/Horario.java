package com.crudjpaHeranca.model.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean disponivel;
    private Time inicio;
    private Time fim;
    private Date dia;
    @ManyToMany(mappedBy = "horarios")
    private List<Agenda> agendas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Time getInicio() {
        return inicio;
    }

    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }

    public Time getFim() {
        return fim;
    }

    public void setFim(Time fim) {
        this.fim = fim;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }
}
