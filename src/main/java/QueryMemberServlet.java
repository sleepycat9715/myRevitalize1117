

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.*;
import model.Member;
import java.util.*;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/QueryMemberServlet")
public class QueryMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRevitalize1117");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Query query = em.createQuery("Select s from Member s ");
        Query query = em.createNamedQuery("Member.findAll");
        @SuppressWarnings("unchecked")
        List<Member> list = (List<Member>) query.getResultList();
        System.out.print("sid");
        System.out.print("\t sname");
        System.out.print("\t password");
        System.out.print("\t email");
        System.out.println("\t\t cell");
        for (Member s : list) {
            System.out.print(s.getSid());
            System.out.print("\t " + s.getSname());
            System.out.print("\t " + s.getPassword());
            System.out.print("\t " + s.getEmail());
            System.out.print("\t " + s.getCell());
            System.out.println();
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        request.setAttribute("members", list);
        request.getRequestDispatcher("member.jsp").forward(request, response);
       // response.getWriter().append("See Tomcat Console Member Data");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
