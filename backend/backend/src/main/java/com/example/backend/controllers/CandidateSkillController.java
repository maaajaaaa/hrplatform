package com.example.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.dao.CandidateSkillRepo;
import com.example.backend.models.candidate;

@RestController
@RequestMapping("/candidate-skill")
@CrossOrigin(origins = "http://localhost:4200/")
public class CandidateSkillController {
    
    @PostMapping("/addskill/{candidate}/{skill}")
    public String addSkillToCandidate(@PathVariable int candidate, @PathVariable int skill) {
        return new CandidateSkillRepo().addSkillToCandidate(candidate, skill);
    }
    
    @GetMapping("/removeskill/{candidate}/{skill}")
    public String removeSkillFromCandidate(@PathVariable int candidate, @PathVariable int skill) {
        return new CandidateSkillRepo().removeSkillFromCandidate(candidate, skill);
    }
    
    @GetMapping("/getskilledcandidates/{skill}")
    public List<candidate> getSkilledCandidates(@PathVariable int skill) {
        return new CandidateSkillRepo().getSkilledCandidates(skill);
    }

}
