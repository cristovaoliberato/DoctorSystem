package com.crudjpaHeranca.controller;

import com.crudjpaHeranca.model.entity.Medico;
import com.crudjpaHeranca.model.repository.EspecialidadeRepository;
import com.crudjpaHeranca.model.repository.MedicoRepository;
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
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;
    @Autowired
    private EspecialidadeRepository repositoryEspecialidade;


    @GetMapping("/list")
    public ModelAndView list(ModelMap modelMap){
        modelMap.addAttribute("medicos", repository.medicos());
        modelMap.addAttribute("especialidadesDisponiveis", repositoryEspecialidade.findAll());
        return new ModelAndView("/medico/list", modelMap);
    }

    @GetMapping("/filtercpm/{crmMedico}")
    public ModelAndView listConsultasMedico(@PathVariable("crmMedico") String crmMedico, ModelMap modelMap){
        modelMap.addAttribute("obj", repository.medico(crmMedico));
        modelMap.addAttribute("medico", true);
        return new ModelAndView("/consulta/listEsp");
    }

    @GetMapping("/formCadastro")
    public ModelAndView formCadastro(Medico medico) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("medico", medico);
        modelMap.addAttribute("especialidadesDisponiveis", repositoryEspecialidade.findAll());
        return new ModelAndView("/medico/create", modelMap);
    }


    @PostMapping("/cadastrar")
    public ModelAndView cadastrarMedico(@Valid Medico medico, BindingResult result)
    {
        if(result.hasErrors())
            return formCadastro(medico);
        repository.save(medico);
        return new ModelAndView("redirect:/medicos/list");
    }

    @GetMapping("/editar/{idMedico}")
    public ModelAndView editarMedico(@PathVariable("idMedico") Long idMedico, ModelMap modelMap){
        modelMap.addAttribute("medico", repository.medicoid(idMedico));
        modelMap.addAttribute("especialidadesDisponiveis", repositoryEspecialidade.findAll());
        return new ModelAndView("/medico/edit");
    }

    @PostMapping("/atualizar")
    public ModelAndView update(@Valid Medico medico, BindingResult result){
        if(result.hasErrors())
            return editarMedico(medico.getId(), new ModelMap());
        repository.update(medico);
        return new ModelAndView("redirect:/medicos/list");
    }

    @GetMapping ("/excluir/{crmMedico}")
    public ModelAndView deletarMedico(@PathVariable("crmMedico") String crmMedico){
        repository.delete(crmMedico);
        return new ModelAndView("redirect:/medicos/list");
    }
}
