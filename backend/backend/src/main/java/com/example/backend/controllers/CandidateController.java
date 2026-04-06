package com.example.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.candidate;
import com.example.backend.services.CandidateService;

@RestController
@RequestMapping("/candidates")
@CrossOrigin(origins = "http://localhost:4200/")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/addcandidate")
    public String addCandidate(@RequestBody candidate candidate){
        return candidateService.addCandidate(candidate);
    }
    
    @GetMapping("/delete/{candidate}")
    public String deleteCandidate(@PathVariable String candidate) {
        return candidateService.deleteCandidate(candidate);
    }
    
    @GetMapping("/{name}")
    public candidate getCandidate(@PathVariable String name){
        return candidateService.getCandidate(name);
    }
}
