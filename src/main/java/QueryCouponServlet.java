

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.*;
import model.Coupon;
import java.util.*;

/**
 * Servlet implementation class QueryCouponServlet
 */
@WebServlet("/QueryCouponServlet")
public class QueryCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCouponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Query query = em.createQuery("Select s from Coupon s ");
        Query query = em.createNamedQuery("Coupon.findAll");
        @SuppressWarnings("unchecked")
        List<Coupon> list = (List<Coupon>) query.getResultList();
        System.out.print("memid");
        System.out.print("\t type01");
        System.out.print("\t type02");
		System.out.print("\t type03");
        System.out.print("\t type04");
        System.out.println("\t sum");
        for (Coupon s : list) {
            System.out.print(s.getMemid());
            System.out.print("\t " + s.getType01());
            System.out.print("\t " + s.getType02());
            System.out.print("\t " + s.getType03());
            System.out.print("\t " + s.getType04());
            System.out.print("\t " + s.getSum());
            System.out.println();
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        request.setAttribute("coupons", list);
        request.getRequestDispatcher("coupon.jsp").forward(request, response);
       // response.getWriter().append("See Tomcat Console coupon Data");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
