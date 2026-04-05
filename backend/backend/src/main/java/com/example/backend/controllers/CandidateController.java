package com.example.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.dao.CandidateRepo;
import com.example.backend.models.candidate;

@RestController
@RequestMapping("/candidates")
@CrossOrigin(origins = "http://localhost:4200/")
public class CandidateController {
    
    @PostMapping("/addcandidate")
    public String addCandidate(@RequestBody candidate candidate){
        return new CandidateRepo().addCandidate(candidate);
    }
    
    @GetMapping("/delete/{candidate}")
    public String deleteCandidate(@PathVariable String candidate) {
        return new CandidateRepo().deleteCandidate(candidate);
    }
    
    @GetMapping("/{name}")
    public candidate getCandidate(@PathVariable String name){
        return new CandidateRepo().getCandidate(name);
    }
}
