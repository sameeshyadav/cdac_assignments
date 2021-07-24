package dao;

import static utils.DBUtils.getDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {
	private Connection cn;
	private PreparedStatement pst1;

	public CandidateDaoImpl() throws ClassNotFoundException,SQLException {
		cn = getDBConnection();
		//pst1 : registering new candidate
		pst1=cn.prepareStatement("insert into candidates (name,party,votes) values(?,?,?)");
		System.out.println("candidate dao created...");
	}

		public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();

		System.out.println("candidate dao cleaned up...");
	}

	@Override
	public String registerCandidate(Candidate c) throws SQLException {
		System.out.println("candidate dao : "+c);
		//set IN params
		pst1.setString(1, c.getName());
		pst1.setString(2, c.getParty());
		pst1.setInt(3, c.getVotes());
		System.out.println("inserting candidate details");
		int rowCount=pst1.executeUpdate();
		if(rowCount == 1)
			return "Reg Success : Details "+c;
		return "Candidate registration failed!!!";
	}
	
	

}
