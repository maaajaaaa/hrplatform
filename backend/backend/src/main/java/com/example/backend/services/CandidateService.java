package com.example.backend.services;

import org.springframework.stereotype.Service;
import com.example.backend.db.dao.CandidateRepoInterface;
import com.example.backend.models.candidate;

@Service
public class CandidateService {

    private final CandidateRepoInterface candidateRepo;

    public CandidateService(CandidateRepoInterface candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    public String addCandidate(candidate candidate) {
        if (candidate.getName() == null || candidate.getName() == "")
            return "Error: Name is required.";
        if (candidate.getEmail() == null || candidate.getEmail() == "")
            return "Error: Email is required.";
        return candidateRepo.addCandidate(candidate);
    }

    public String deleteCandidate(String name) {
        if (name == null || name == "")
            return "Error: Name is required.";
        return candidateRepo.deleteCandidate(name);
    }

    public candidate getCandidate(String name) {
        if (name == null || name == "")
            return null;
        return candidateRepo.getCandidate(name);
    }
}
