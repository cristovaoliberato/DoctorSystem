package com.crudjpaHeranca.controller;

import com.crudjpaHeranca.model.entity.Paciente;
import com.crudjpaHeranca.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @GetMapping("/list")
    public ModelAndView list(ModelMap modelMap){
        modelMap.addAttribute("pacientes", repository.pacientes());
        return new ModelAndView("/paciente/list", modelMap);
    }

    @GetMapping("/consultasPaciente/{pacienteId}")
    public ModelAndView listConsultasPaciente(@PathVariable("pacienteId") Long pacienteId, ModelMap modelMap){
        modelMap.addAttribute("obj", repository.paciente(pacienteId));
        modelMap.addAttribute("medico", false);
        return new ModelAndView("/consulta/listEsp");
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarPaciente(@Valid Paciente paciente, BindingResult result)
    {
        if(result.hasErrors())
            return formCadastro(paciente);
        repository.save(paciente);
        return new ModelAndView("redirect:/pacientes/list");
    }

    @GetMapping("/editar/{pacienteId}")
    public ModelAndView editarPaciente(@PathVariable("pacienteId") Long pacienteId, ModelMap modelMap){
        modelMap.addAttribute("paciente", repository.paciente(pacienteId));
        return new ModelAndView("/paciente/edit");
    }
    @GetMapping("/formCadastro")
    public ModelAndView formCadastro(Paciente paciente){
        return new ModelAndView("/paciente/create");
    }
    @PostMapping("/atualizar")
    public ModelAndView update(@Valid Paciente paciente, BindingResult result){
        if(result.hasErrors())
            return editarPaciente(paciente.getId(), new ModelMap());
        repository.update(paciente);
        return new ModelAndView("redirect:/pacientes/list");
    }

    @GetMapping("/excluir/{pacienteId}")
    public ModelAndView deletarPaciente(@PathVariable("pacienteId") Long pacienteId){
        repository.delete(pacienteId);
        return new ModelAndView("redirect:/pacientes/list");
    }
}
