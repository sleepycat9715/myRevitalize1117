

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Coupon;

/**
 * Servlet implementation class UpdateCouponServlet
 */
@WebServlet("/UpdateCouponServlet2")
public class UpdateCouponServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCouponServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();       
        String temp = request.getParameter("obj");	
        Gson gson=new Gson();
        Coupon cp=gson.fromJson(temp, Coupon.class);        
		Coupon sx=em.find(Coupon.class, cp.getMemid());
        if(sx !=null) {        	
            sx.setType01(cp.getType01());
            sx.setType02(cp.getType02());
            sx.setType03(cp.getType03());
            sx.setType04(cp.getType04());
            sx.setSum(cp.getSum());
        	em.merge(sx);
        	em.getTransaction().commit();
        }else {
          System.out.println("coupon not found");
          em.getTransaction().rollback();
	    }        
        em.close();
        emf.close();
        //response.sendRedirect("QueryCouponServlet");
        

	}

}
