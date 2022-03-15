package com.github.kis8ya.sfpetclinic.controllers;

import com.github.kis8ya.sfpetclinic.model.Owner;
import com.github.kis8ya.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"", "/"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/list";
    }

    @GetMapping({"find"})
    public String find() {
        return "not-implemented";
    }

    @GetMapping("/{id}")
    public String listOwners(Model model, @PathVariable Long id) {
        Optional<Owner> owner = ownerService.findById(id);
        if (!owner.isPresent()) {
            return "not-implemented";
        }
        model.addAttribute("owner", owner.get());
        return "owners/get";
    }


}
