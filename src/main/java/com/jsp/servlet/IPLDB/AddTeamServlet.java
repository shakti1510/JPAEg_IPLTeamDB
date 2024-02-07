package com.jsp.servlet.IPLDB;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddTeam")
public class AddTeamServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IPLTeam ipl=new IPLTeam();
		int playerId=Integer.parseInt(req.getParameter("playerId"));
		String playerName=req.getParameter("playerName");
		int playerAge=Integer.parseInt(req.getParameter("playerAge"));
		String playerCountry=req.getParameter("playerCountry");
		String iplTeam=req.getParameter("iplTeam");
		int salary=Integer.parseInt(req.getParameter("salary"));
		ipl.setPlayerId(playerId);
		ipl.setPlayerName(playerName);
		ipl.setPlayerAge(playerAge);
		ipl.setPlayerCountry(playerCountry);
		ipl.setIplTeam(iplTeam);
		ipl.setSalary(salary);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("iplDb");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(ipl);
		et.commit();
		em.close();
		
		resp.sendRedirect("Complete.jsp?msg=Inserted");
	}
}
