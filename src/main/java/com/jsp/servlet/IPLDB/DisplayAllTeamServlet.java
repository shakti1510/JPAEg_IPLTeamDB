package com.jsp.servlet.IPLDB;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/DisplayAllTeam")
public class DisplayAllTeamServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("iplDb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<IPLTeam> createQuery = cb.createQuery(IPLTeam.class);
		Root<IPLTeam> root = createQuery.from(IPLTeam.class);
		createQuery.select(root);
		Query q=em.createQuery(createQuery);
		List<IPLTeam> solution = q.getResultList();
		req.setAttribute("solution", solution);
		RequestDispatcher rd = req.getRequestDispatcher("DisplayAllTeam.jsp");
		rd.forward(req, resp);
		et.commit();
		em.close();
	}
}
