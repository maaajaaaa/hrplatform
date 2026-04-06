package com.example.backend.db.dao;

import java.util.List;

import com.example.backend.models.skill;

public interface SkillRepoInterface {
    public String addSkills(List<skill> skills);
}
