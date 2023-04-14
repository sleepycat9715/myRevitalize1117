

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.*;
import model.Coupon;

/**
 * Servlet implementation class AddCouponServlet
 */
@WebServlet("/AddCouponServlet")
public class AddCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCouponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
  
		String memid=request.getParameter("memid");
		Integer type01=Integer.parseInt(request.getParameter("type01"));
		Integer type02=Integer.parseInt(request.getParameter("type02"));
		Integer type03=Integer.parseInt(request.getParameter("type03"));
		Integer type04=Integer.parseInt(request.getParameter("type04"));
		Integer sum=Integer.parseInt(request.getParameter("sum"));
		
		Coupon s=new Coupon(memid,type01,type02,type03,type04,sum);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();     
		
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
        response.sendRedirect("QueryCouponServlet");
	}

}
