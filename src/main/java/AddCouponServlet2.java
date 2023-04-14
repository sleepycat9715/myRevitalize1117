

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import javax.persistence.*;
import model.Coupon;
import model.JasonUser;

import com.google.gson.*;
/**
 * Servlet implementation class AddCouponServlet
 */
@WebServlet("/AddCouponServlet2")
public class AddCouponServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCouponServlet2() {
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
		//doGet(request, response);
//		int type01=0;
//		int type02=0;
//		int type03=0; 
//		int type04=0;
//		Integer sum=0;
//		String memid=request.getParameter("memid");
		String temp = request.getParameter("obj");		
//		String[] a = temp.split(",");
//	    for(int x=0; x<a.length; x++) {
//	    	String type=a[x].replace("[","").replace("]","");
//	    	String typenext=a[x+1].replace("]", "");
//	        if(type.equals("type01")) {
//	        	type01=Boolean.parseBoolean(typenext)?1:0;
//	        }else if(type.equals("'type02'")) {
//	        	type02=Boolean.parseBoolean(typenext)?1:0;
//	        }else if(type.equals("'type03'")) {
//	        	type03=Boolean.parseBoolean(typenext)?1:0;
//	        }else if(type.equals("'type04'")) {
//	        	type04=Boolean.parseBoolean(typenext)?1:0;
//	        }
//	    }				
//		Coupon s=new Coupon(memid,type01,type02,type03,type04,sum);
        Gson gson=new Gson();
        Coupon cp=gson.fromJson(temp, Coupon.class);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();		
        em.persist(cp);
        em.getTransaction().commit();
        em.close();
        emf.close();
        //response.sendRedirect("QueryCouponServlet");
	}

}
