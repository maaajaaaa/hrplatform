package com.example.backend.db.dao;

import com.example.backend.models.candidate;

public interface CandidateRepoInterface {
    public String addCandidate(candidate candidate);
    public String deleteCandidate(String candidate);
    public candidate getCandidate(String name);
}
