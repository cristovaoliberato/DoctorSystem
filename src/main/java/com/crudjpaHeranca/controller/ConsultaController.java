package com.crudjpaHeranca.controller;

import com.crudjpaHeranca.model.entity.Consulta;
import com.crudjpaHeranca.model.repository.ConsultaRepository;
import com.crudjpaHeranca.model.repository.MedicoRepository;
import com.crudjpaHeranca.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Transactional
@Controller
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private PacienteRepository repoPaciente;
    @Autowired
    private MedicoRepository repoMedico;

    @GetMapping("/list")
    public ModelAndView list(ModelMap modelMap){
        modelMap.addAttribute("consultas", repository.consultas());
        return new ModelAndView("/consulta/list", modelMap);
    }

    @GetMapping("/formCadastro")
    public String insert(Consulta consulta, Model model)
    {
        model.addAttribute("medicos", repoMedico.medicos());
        model.addAttribute("pacientes", repoPaciente.pacientes());
        model.addAttribute("consulta", consulta);
        return "/consulta/insert";
    }

    @GetMapping("/editar/{idConsulta}")
    public ModelAndView editar(@PathVariable("idConsulta") String idConsulta, ModelMap modelMap){
        modelMap.addAttribute("consulta", repository.consultaid(Long.parseLong(idConsulta)));
        modelMap.addAttribute("editing", true);
        return new ModelAndView("/consulta/detalhes");
    }
    @PostMapping("/atualizar")
    public String update(@ModelAttribute("consulta") Consulta consulta)
    {
        repository.update(consulta);
        return "redirect:/home";
    }
    @GetMapping("/detalharConsulta/{idConsulta}")
    public ModelAndView detalhar(@PathVariable("idConsulta") String idConsulta, ModelMap modelMap){
        modelMap.addAttribute("consulta", repository.consultaid(Long.parseLong(idConsulta)));
        modelMap.addAttribute("editing", false);
        return new ModelAndView("/consulta/detalhes");
    }
    @PostMapping("/criar")
    public String salvarConsulta(@Valid Consulta consulta, BindingResult result, Model model)
    {
        consulta.setData(LocalDateTime.now());
        if(result.hasErrors())
            return insert(consulta, model);
        repository.save(consulta);
        return "redirect:/home";
    }
    @GetMapping("/excluir/{id}")
    public String deletarConsulta(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        repository.delete(id);
        return "redirect:/home";
    }
}
