

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
 * Servlet implementation class DeleteCouponServlet
 */
@WebServlet("/DeleteCouponServlet")
public class DeleteCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCouponServlet() {
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
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myRevitalize1117");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Coupon sx=manager.find(Coupon.class, memid);
		 if(sx !=null) {        	
	         manager.remove(sx);   
			 manager.getTransaction().commit();
	        }else {
	          System.out.println("Coupon not found");
	          manager.getTransaction().rollback();
		    }        
		    manager.close();
	        factory.close();
	        response.sendRedirect("QueryCouponServlet");
	}

}
