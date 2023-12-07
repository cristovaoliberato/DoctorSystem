package com.crudjpaHeranca.controller;

import com.crudjpaHeranca.model.entity.Agenda;
import com.crudjpaHeranca.model.entity.Horario;
import com.crudjpaHeranca.model.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/agendas")
public class AgendaController {
    @Autowired
    private HorarioRepository horarioRepository;
    @GetMapping
    public ModelAndView form(ModelMap modelMap)
    {
        LocalDate dataAtual = LocalDate.now();
        Month mesAtual = dataAtual.getMonth();
        List<LocalDate> diasUteis = obterDiasUteisNoMes(dataAtual);
        modelMap.addAttribute("horarios", horarioRepository.findAll());
        modelMap.addAttribute("diasMes", diasUteis);
        modelMap.addAttribute("horario", new Horario());
        return new ModelAndView("/agenda/formAgenda");
    }
    private static List<LocalDate> obterDiasUteisNoMes(LocalDate data) {
        List<LocalDate> diasUteis = new ArrayList<>();
        LocalDate primeiroDiaDoMes = data.withDayOfMonth(1);
        while (primeiroDiaDoMes.getMonth() == data.getMonth()) {
            if (ehDiaUtil(primeiroDiaDoMes)) {
                diasUteis.add(primeiroDiaDoMes);
            }
            primeiroDiaDoMes = primeiroDiaDoMes.plusDays(1);
        }

        return diasUteis;
    }
    private static boolean ehDiaUtil(LocalDate data) {
        DayOfWeek dayOfWeek = data.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }
}

