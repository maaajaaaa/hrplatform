package com.example.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.skill;
import com.example.backend.services.SkillService;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200/")
public class SkillController {

    private final SkillService skillService;
    
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/addskills")
    public String addSkills(@RequestBody List<skill> skills){
        return skillService.addSkills(skills);
    }
}
