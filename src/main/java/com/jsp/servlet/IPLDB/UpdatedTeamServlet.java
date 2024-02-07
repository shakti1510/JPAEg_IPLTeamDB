package com.jsp.servlet.IPLDB;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTeamTable")
public class UpdatedTeamServlet extends HttpServlet{
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
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaUpdate<IPLTeam> update = cb.createCriteriaUpdate(IPLTeam.class);
		Root<IPLTeam> root=update.from(IPLTeam.class);
		update.set(root.get("playerName"),playerName);
		update.set(root.get("playerAge"),playerAge);
		update.set(root.get("playerCountry"),playerCountry);
		update.set(root.get("iplTeam"),iplTeam);
		update.set(root.get("salary"),salary);
		update.where(cb.equal(root.get("playerId"), playerId));
		
		Query q=em.createQuery(update);
		q.executeUpdate();
		
		et.commit();
		em.close();
		
		resp.sendRedirect("DisplayAllTeam");
	}
}
