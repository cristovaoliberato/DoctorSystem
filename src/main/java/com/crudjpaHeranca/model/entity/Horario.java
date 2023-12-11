package com.crudjpaHeranca.model.entity;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean disponivel;
    private boolean fixed;
    private Time inicio;
    private Time fim;
    private Date dia;
    @ManyToOne
    private Medico medico;

    public Horario() {
    }

    public Horario(boolean disponivel, boolean fixed, Time inicio, Time fim, Date dia, Medico medico) {
        this.disponivel = disponivel;
        this.fixed = fixed;
        this.inicio = inicio;
        this.fim = fim;
        this.dia = dia;
        this.medico = medico;
    }

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


    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
