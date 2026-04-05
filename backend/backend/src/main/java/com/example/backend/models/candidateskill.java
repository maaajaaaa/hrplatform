package com.example.backend.models;

public class candidateskill {
    private int candidate_id;
    private int skill_id;

    
    public candidateskill(int candidate_id, int skill_id) {
        this.candidate_id = candidate_id;
        this.skill_id = skill_id;
    }
    public int getCandidate_id() {
        return candidate_id;
    }
    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }
    public int getSkill_id() {
        return skill_id;
    }
    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    
}
