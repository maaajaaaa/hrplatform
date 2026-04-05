package com.example.backend.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

import com.example.backend.db.DB;
import com.example.backend.models.candidate;

public class CandidateRepo {

    public String addCandidate(candidate candidate) {
        //check if candidate already exists or email is already used
        try (
            Connection conn = DB.source().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("insert into candidates (name, date_of_birth, contact_number, email) values (?, ?, ?, ?)");
        ) {
            pstmt.setString(1, candidate.getName());
            pstmt.setDate(2, candidate.getDate_of_birth());
            pstmt.setString(3, candidate.getContact_number());
            pstmt.setString(4, candidate.getEmail());

            if( pstmt.executeUpdate() > 0 ) {
                return "Candidate added successfully.";
            }
            else {
                return "Error.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteCandidate(String candidate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCandidate'");
    }

    public candidate getCandidate(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCandidate'");
    }
    
}
