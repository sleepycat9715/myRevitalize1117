

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coupon;

/**
 * Servlet implementation class UpdateCouponServlet
 */
@WebServlet("/UpdateCouponServlet")
public class UpdateCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCouponServlet() {
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();       
		String memid=request.getParameter("memid");
		Integer type01=Integer.parseInt(request.getParameter("type01"));
		Integer type02=Integer.parseInt(request.getParameter("type02"));
		Integer type03=Integer.parseInt(request.getParameter("type03"));
		Integer type04=Integer.parseInt(request.getParameter("type04"));
		Integer sum=Integer.parseInt(request.getParameter("sum"));
        
		Coupon sx=em.find(Coupon.class, memid);
        if(sx !=null) {        	
            sx.setType01(type01);
            sx.setType02(type02);
            sx.setType03(type03);
            sx.setType04(type04);
            sx.setSum(sum);
        	em.merge(sx);
        	em.getTransaction().commit();
        }else {
          System.out.println("coupon not found");
          em.getTransaction().rollback();
	    }        
        em.close();
        emf.close();
        response.sendRedirect("QueryCouponServlet");
        

	}

}
