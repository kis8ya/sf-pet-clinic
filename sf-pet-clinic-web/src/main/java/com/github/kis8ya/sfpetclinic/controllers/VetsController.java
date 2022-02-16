package com.github.kis8ya.sfpetclinic.controllers;

import com.github.kis8ya.sfpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/", ""})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/list";
    }
}
