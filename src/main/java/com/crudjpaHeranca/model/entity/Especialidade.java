package com.crudjpaHeranca.model.entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo não pode ser vazio")
    private String nome;
    @ManyToMany(mappedBy = "especialidades")
    private List<Medico> medicos;

    public Especialidade(String nome, List<Medico> medicos) {
        this.nome = nome;
        this.medicos = medicos;
    }

    public Especialidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
