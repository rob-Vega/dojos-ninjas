package com.robvega.dojosninjas.controller;

import com.robvega.dojosninjas.model.Dojo;
import com.robvega.dojosninjas.service.DojoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DojoController {

    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("dojos/new")
    public String create(@ModelAttribute("Dojo") Dojo dojo) {
        return "newDojo.jsp";
    }

    @PostMapping("dojos/new")
    public String create(
            @Valid @ModelAttribute("Dojo") Dojo dojo,
            BindingResult result
    ) {
        if (result.hasErrors()) return "newDojo.jsp";

        dojoService.create(dojo);
        return "redirect:/dojos/new";
    }

    @GetMapping("dojos/{id}")
    public String get(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dojo", dojoService.findById(id));
        return "dojo.jsp";
    }
}
