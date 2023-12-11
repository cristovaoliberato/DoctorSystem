package com.crudjpaHeranca.controller;

import com.crudjpaHeranca.model.entity.Horario;
import com.crudjpaHeranca.model.entity.Medico;
import com.crudjpaHeranca.model.repository.HorarioRepository;
import com.crudjpaHeranca.model.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.core.io.NumberInput.parseLong;

@Controller
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @GetMapping()
    public ModelAndView form(ModelMap modelMap)
    {
        LocalDate dataAtual = LocalDate.now();
        List<LocalDate> diasUteis = obterDiasUteisNoMes(dataAtual);
        modelMap.addAttribute("horarios", horarioRepository.findALLByIsFixed());
        modelMap.addAttribute("diasMes", diasUteis);
        modelMap.addAttribute("horario", new Horario());
        return new ModelAndView("/agenda/formHorario");
    }
    @GetMapping("/list")
    public ModelAndView list(ModelMap modelMap, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String medicoCrm = userDetails.getUsername();
        Medico medico = medicoRepository.medico(medicoCrm);
        modelMap.addAttribute("horarios", horarioRepository.findHorariosByMedicoCrm(medico.getId()));
        return new ModelAndView("/agenda/listByMedico", modelMap);
    }
    @Transactional
    @PostMapping("/insert")
    public ModelAndView insertHorario(@RequestParam String crmMedico, @RequestParam List<String> horarioDia)
    {
        for (int i = 0; i < horarioDia.size(); i++) {
            String[] partes = horarioDia.get(i).split(":");
            Long horarioId = parseLong(partes[0]);
            String dataSelecionada = partes[1];
            Horario horarioOriginal = horarioRepository.findByID(horarioId);
            Date date = getDate(dataSelecionada);
            Medico medico = medicoRepository.medico(crmMedico);
            Horario horarioCopia = new Horario(true, false, horarioOriginal.getInicio(), horarioOriginal.getFim(), date, medico);
            horarioRepository.save(horarioCopia);
            List<Horario> horariosMedico = medico.getHorarios();
            horariosMedico.add(horarioCopia);
            medicoRepository.update(medico);
        }
        return new ModelAndView("/home");
    }

    private static Date getDate(String dataSelecionada) {
        LocalDate localDate = LocalDate.parse(dataSelecionada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Date date = java.sql.Date.valueOf(localDate);
        return date;
    }

    //Extract Methods
    private static List<LocalDate> obterDiasUteisNoMes(LocalDate data) {
        List<LocalDate> diasUteis = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        int dayOfMonth = currentDate.getDayOfMonth();
        LocalDate atualDiaDoMes = LocalDate.now().withDayOfMonth(dayOfMonth);
        while (!ehDiaUtil(atualDiaDoMes))
        {
            atualDiaDoMes = atualDiaDoMes.plusDays(1);
        }
        while (atualDiaDoMes.getMonth() == data.getMonth()) {
            diasUteis.add(atualDiaDoMes);
            atualDiaDoMes = atualDiaDoMes.plusDays(1);
            while (!ehDiaUtil(atualDiaDoMes)) {
                atualDiaDoMes = atualDiaDoMes.plusDays(1);
            }
        }
        return diasUteis;
    }

    private static boolean ehDiaUtil(LocalDate data) {
        DayOfWeek dayOfWeek = data.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }
}

