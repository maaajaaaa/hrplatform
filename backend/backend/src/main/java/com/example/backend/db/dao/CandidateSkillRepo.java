package com.example.backend.db.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.Connection;

import com.example.backend.db.DB;
import com.example.backend.models.candidate;

@Repository
public class CandidateSkillRepo implements CandidateSkillRepoInterface {

    public String addSkillToCandidate(int candidate, int skill) {
        try (
            Connection conn = DB.source().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("insert into candidate_skills (candidate_id, skill_id) values (?, ?)");
        ) {
            pstmt.setInt(1, candidate);
            pstmt.setInt(2, skill);

             if( pstmt.executeUpdate() > 0 ) {
                return "Skill added to candidate successfully.";
            }
            else {
                return "Error.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String removeSkillFromCandidate(int candidate, int skill) {
        try (
            Connection conn = DB.source().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("delete from candidate_skills where candidate_id = ? and skill_id = ?");
        ) {
            pstmt.setInt(1, candidate);
            pstmt.setInt(2, skill);

            if( pstmt.executeUpdate() > 0 ) {
                return "Skill removed from candidate successfully.";
            }
            else {
                return "Error.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<candidate> getSkilledCandidates(int skill) {
        try(
            Connection conn = DB.source().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select c.* from candidates c join candidate_skills cs on c.id = cs.candidate_id where cs.skill_id = ?");
        ) {
            pstmt.setInt(1, skill);
            List<candidate> candidates = new java.util.ArrayList<>();
            var rs = pstmt.executeQuery();
            while(rs.next()) {
                candidates.add(new candidate(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getDate("date_of_birth"),
                    rs.getString("contact_number")
                ));
            }
            return candidates;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
