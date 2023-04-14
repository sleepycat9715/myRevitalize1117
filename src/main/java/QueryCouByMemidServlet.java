

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coupon;
import java.util.*;

/**
 * Servlet implementation class QueryCouByMemidServlet
 */
@WebServlet("/QueryCouByMemidServlet")
public class QueryCouByMemidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCouByMemidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memid=request.getParameter("memid");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myRevitalize1117");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Coupon> query=manager.createQuery("select s from Coupon s where s.memid = :a",Coupon.class);
		query.setParameter("a", memid);
	    List<Coupon>  data=query.getResultList();
	    manager.getTransaction().commit();
        manager.close();
        factory.close();
	    request.setAttribute("coupons", data);
	    request.getRequestDispatcher("coupon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
