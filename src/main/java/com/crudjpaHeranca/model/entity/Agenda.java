package com.crudjpaHeranca.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Agenda
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "agenda_horarios",
            joinColumns = @JoinColumn(name = "agenda_id"),
            inverseJoinColumns = @JoinColumn(name = "horario_id"))
    private List<Horario> horarios;

    public Agenda() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
