

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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
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
		String id=request.getParameter("sid");
		String name=request.getParameter("sname");
		String pw=request.getParameter("password");
		String email=request.getParameter("email");
		String cell=request.getParameter("cell");      
        
        Member sx=em.find(Member.class, id);
        if(sx !=null) {        	
            sx.setSname(name);
            sx.setPassword(pw);
			sx.setEmail(email);
			sx.setCell(cell);
        	em.merge(sx);
        	em.getTransaction().commit();
        }else {
          System.out.println("student not found");
          em.getTransaction().rollback();
	    }        
        em.close();
        emf.close();
        response.sendRedirect("QueryMemberServlet");
        

	}

}
