package com.example.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.dao.SkillRepo;
import com.example.backend.models.skill;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200/")
public class SkillController {
    
    @PostMapping("/addskills")
    public String addSkills(@RequestBody List<skill> skills){
        return new SkillRepo().addSkills(skills);
    }
}
