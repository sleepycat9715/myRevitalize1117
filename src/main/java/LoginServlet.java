import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coupon;
import model.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Login:page2轉換頁面page5*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Query query = em.createQuery("Select m from Member m ");
        Query query = em.createNamedQuery("Member.findAll");
        @SuppressWarnings("unchecked")
        List<Member> list = (List<Member>) query.getResultList();
        
        String id=request.getParameter("sid");
        String pass=request.getParameter("pwd");
        boolean x=false;
        for (Member m : list) {
            if(id.equals(m.getSid()) && pass.equals(m.getPassword()))
        	{
        		x=true;
        		break;
        	}
        }
        System.out.println(x);     
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myRevitalize1117");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Coupon> query2=manager.createQuery("select s from Coupon s where s.memid = :a",Coupon.class);
		query2.setParameter("a", id);
	    List<Coupon>  data=query2.getResultList();
	    for (Coupon m : data) {	  
	    	//request.getSession().setAttribute("type0101", m.getMemid());
	    	request.getSession().setAttribute("type0101", m.getType01());
	    	request.getSession().setAttribute("type0202", m.getType02());
	    	request.getSession().setAttribute("type0303", m.getType03());
	    	request.getSession().setAttribute("type0404", m.getType04());	    	
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        //轉資料給(html轉jsp)page5.jsp        
        if(x) {
        	request.getSession().setAttribute("LoginId", id);
        	response.sendRedirect("coupon.html");
        }	
        //request.getRequestDispatcher("page5.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
