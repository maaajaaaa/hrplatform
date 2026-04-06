package com.example.backend.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.backend.db.dao.SkillRepoInterface;
import com.example.backend.models.skill;

@Service
public class SkillService {

    private final SkillRepoInterface skillRepo;

    public SkillService(SkillRepoInterface skillRepo) {
        this.skillRepo = skillRepo;
    }

    public String addSkills(List<skill> skills) {
        if (skills == null || skills.isEmpty())
            return "Error: Skills list required.";
        for (skill s : skills) {
            if (s.getName() == null || s.getName() == "")
                return "Error: Skill name required.";
        }
        return skillRepo.addSkills(skills);
    }
}
