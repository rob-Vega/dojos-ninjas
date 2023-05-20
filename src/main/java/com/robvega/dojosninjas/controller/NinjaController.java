package com.robvega.dojosninjas.controller;

import com.robvega.dojosninjas.model.Ninja;
import com.robvega.dojosninjas.service.DojoService;
import com.robvega.dojosninjas.service.NinjaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NinjaController {

    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @GetMapping("ninjas/new")
    public String create(@ModelAttribute("Ninja") Ninja ninja, Model model) {
        model.addAttribute("dojosList", dojoService.findAll());
        return "newNinja.jsp";
    }

    @PostMapping("ninjas/new")
    public String create(
            @Valid
            @ModelAttribute("Ninja") Ninja ninja,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("dojosList", dojoService.findAll());
            return "newNinja.jsp";
        }

        ninjaService.create(ninja);
        return "redirect:/ninjas/new";
    }
}
