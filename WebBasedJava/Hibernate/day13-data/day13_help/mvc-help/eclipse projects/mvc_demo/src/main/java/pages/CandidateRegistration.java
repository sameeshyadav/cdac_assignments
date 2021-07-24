package pages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CandidateBean;

/**
 * Servlet implementation class CandidateRegistration
 */
@WebServlet("/candidate_registration")
public class CandidateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// get request parameters
			String name = request.getParameter("name");
			String party = request.getParameter("party");
			String dob = request.getParameter("dob");
			//OR invoke parameterized constr
			CandidateBean bean = new CandidateBean();
			request.setAttribute("candidate_bean", bean);
			bean.setName(name);
			bean.setParty(party);
			bean.setDob(dob);
			//invoke B.L method
			String viewName=bean.validateNRegisterCandidate();
			//RD
			RequestDispatcher rd=request.getRequestDispatcher(viewName.concat(".jsp"));
			rd.forward(request, response);
			System.out.println("came back....");
		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}

	}

}
