package com.example.SecurityApp.controllers;

import com.example.SecurityApp.models.Person;
import com.example.SecurityApp.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PeopleService peopleService;
     @Autowired
    public AdminController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String adminPage(Model model){
         model.addAttribute("people",peopleService.showAll("ROLE_USER"));
        return "admin";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
         model.addAttribute("person",peopleService.findById(id));
          return "show";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/admin";
    }
}
