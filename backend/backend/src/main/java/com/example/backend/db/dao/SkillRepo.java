package com.example.backend.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.backend.db.DB;
import com.example.backend.models.skill;

@Repository
public class SkillRepo implements SkillRepoInterface {

    public String addSkills(List<skill> skills) {
        try(
            Connection conn = DB.source().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("insert into skills (name) values (?)");
        ){
            for(skill skill : skills) {
                pstmt.setString(1, skill.getName());
                pstmt.addBatch();
            }
            int[] result = pstmt.executeBatch();
            if(result.length > 0) {
                return "Skills added successfully.";
            }
            else {
                return "Error.";
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
        
    }
    
}
