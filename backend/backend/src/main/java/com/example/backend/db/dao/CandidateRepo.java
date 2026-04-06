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
        try (
            Connection conn = DB.source().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("delete from candidates where name = ?");
        ) {
            pstmt.setString(1, candidate);

            if( pstmt.executeUpdate() > 0 ) {
                return "Candidate deleted successfully.";
            }
            else {
                return "Error.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public candidate getCandidate(String name) {
        try (
            Connection conn = DB.source().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from candidates where name = ?");
        ) {
            pstmt.setString(1, name);
            var rs = pstmt.executeQuery();

            if( rs.next() ) {
                return new candidate(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getDate("date_of_birth"),
                    rs.getString("contact_number")
                );
            }
            else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
