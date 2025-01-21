package org.devin.calendar.controller;


import org.devin.calendar.dto.EintragDTO;
import org.devin.calendar.model.Eintrag;
import org.devin.calendar.service.EintragService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalenderController {

    private final EintragService eintragService;

    public CalenderController(EintragService eintragService) {
        this.eintragService = eintragService;
    }

    @GetMapping("/")
    public String index() {
        System.out.println("Getmapping auf /");
        return "weekly-calendar";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("eintragDTO", new EintragDTO());
        System.out.println("Getmapping auf /add");
        return "add";
    }

    @PostMapping("/add")
    public String addEvent(@ModelAttribute EintragDTO eintragDTO, RedirectAttributes redirectAttributes) {
        System.out.println("Postmapping auf /add");
        Eintrag createdEintrag = eintragService.createEintrag(eintragDTO);
        System.out.println(createdEintrag.toString());
        redirectAttributes.addFlashAttribute("createdEintrag", createdEintrag);
        return "redirect:/add";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }
}
