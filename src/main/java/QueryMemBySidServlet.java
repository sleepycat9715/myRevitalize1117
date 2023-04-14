

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import java.util.*;

/**
 * Servlet implementation class QueryMemBySidServlet
 */
@WebServlet("/QueryMemBySidServlet")
public class QueryMemBySidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMemBySidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid=request.getParameter("sid");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myRevitalize1117");
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Member> query=manager.createQuery("select s from Member s where s.sid = :a",Member.class);
		query.setParameter("a", sid);
	    List<Member>  data=query.getResultList();
	    manager.getTransaction().commit();
        manager.close();
        factory.close();
	    request.setAttribute("members", data);
	    request.getRequestDispatcher("member.jsp").forward(request, response);
	    
        //data先丟到Request裡(Session)，從另外一頁拿回來
        //response.sendRedirect("page_03");
	    //request.setAttribute("members", data);
	    //request.getRequestDispatcher("page_03.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
