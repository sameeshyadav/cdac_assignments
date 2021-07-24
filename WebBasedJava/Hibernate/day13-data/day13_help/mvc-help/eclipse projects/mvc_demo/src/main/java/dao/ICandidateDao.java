package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	
	//add a method to register a new candidate
	String registerCandidate(Candidate c) throws SQLException;
}
