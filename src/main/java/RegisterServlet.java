

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coupon;
import model.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String id=request.getParameter("sid");
		String name=request.getParameter("sname");
		String pw=request.getParameter("password");
		String email=request.getParameter("email");
		String cell=request.getParameter("cell");		
		Member s=new Member(id,name,pw,email,cell);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Query query = em.createQuery("Select m from Member m ");
        Query query = em.createNamedQuery("Member.findAll");
        @SuppressWarnings("unchecked")
        List<Member> list = (List<Member>) query.getResultList();
        
        boolean id_IsExist=false;
        for (Member m : list) {
            if(id.equals(m.getSid()))
        	{
            	id_IsExist=true;
        		break;
        	}
        }
        System.out.println("id_IsExist="+id_IsExist); 

        request.getSession().setAttribute("id_IsExist", id_IsExist);        
        if(id_IsExist==false) {    // register member
					
        	em.persist(s); 
    		Coupon cou=new Coupon(id,0,0,0,0,0); 		
            em.persist(cou);
            em.getTransaction().commit();
            em.close();
            emf.close(); 
        	response.sendRedirect("coupon.html");
            
        }else {   				  // already exist, reg. failed
            em.getTransaction().commit();
            em.close();
            emf.close(); 
        }
        
          	
    	
	}

}
