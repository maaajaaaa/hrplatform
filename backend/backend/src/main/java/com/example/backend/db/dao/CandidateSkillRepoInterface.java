package com.example.backend.db.dao;

import java.util.List;

import com.example.backend.models.candidate;

public interface CandidateSkillRepoInterface {
    public String addSkillToCandidate(int candidate, int skill);
    public String removeSkillFromCandidate(int candidate, int skill);
    public List<candidate> getSkilledCandidates(int skill);
}
