package com.example.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.backend.db.dao.CandidateSkillRepoInterface;
import com.example.backend.models.candidate;

@Service
public class CandidateSkillService {

    private final CandidateSkillRepoInterface candidateSkillRepo;

    public CandidateSkillService(CandidateSkillRepoInterface candidateSkillRepo) {
        this.candidateSkillRepo = candidateSkillRepo;
    }

    public String addSkillToCandidate(int candidateId, int skillId) {
        if (candidateId <= 0 || skillId <= 0)
            return "Error: Invalid candidate or skill id.";
        return candidateSkillRepo.addSkillToCandidate(candidateId, skillId);
    }

    public String removeSkillFromCandidate(int candidateId, int skillId) {
        if (candidateId <= 0 || skillId <= 0)
            return "Error: Invalid candidate or skill id.";
        return candidateSkillRepo.removeSkillFromCandidate(candidateId, skillId);
    }

    public List<candidate> getSkilledCandidates(int skillId) {
        if (skillId <= 0) return null;
        return candidateSkillRepo.getSkilledCandidates(skillId);
    }
}
