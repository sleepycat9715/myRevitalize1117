

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberServlet() {
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
		String sid=request.getParameter("sid");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myRevitalize1117");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Member sx=manager.find(Member.class, sid);
		 if(sx !=null) {        	
	         manager.remove(sx);   
			 manager.getTransaction().commit();
	        }else {
	          System.out.println("Member not found");
	          manager.getTransaction().rollback();
		    }        
		    manager.close();
	        factory.close();
	        response.sendRedirect("QueryMemberServlet");
	}

}
