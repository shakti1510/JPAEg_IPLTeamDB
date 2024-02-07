package com.jsp.servlet.IPLDB;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletePlayer")
public class DeletePlayerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int playerId=Integer.parseInt(req.getParameter("playerId"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("iplDb");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaDelete<IPLTeam> delete = cb.createCriteriaDelete(IPLTeam.class);
		Root<IPLTeam> root = delete.from(IPLTeam.class);
		delete.where(cb.equal(root.get("playerId"), playerId));
		
		Query q=em.createQuery(delete);
		q.executeUpdate();
		
		et.commit();
		em.close();
		
		resp.sendRedirect("DisplayAllTeam");
	}
}
