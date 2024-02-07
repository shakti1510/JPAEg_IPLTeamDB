package com.jsp.servlet.IPLDB;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatePlayer")
public class UpdatePlayerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int playerId=Integer.parseInt(req.getParameter("playerId"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("iplDb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		IPLTeam res = em.find(IPLTeam.class, playerId);
		et.commit();
		em.close();
		
		req.setAttribute("teamData", res);
		RequestDispatcher rd = req.getRequestDispatcher("UpdateTeam.jsp");
		rd.forward(req, resp);
	}
}
