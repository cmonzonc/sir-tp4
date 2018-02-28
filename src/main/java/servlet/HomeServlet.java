package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.HomeAPI;
import api.PersonAPI;
import opower.Home;
import opower.Person;

@WebServlet(
    name = "home",
    urlPatterns = { "/home" }
)
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Home home = new Home(Double.parseDouble(request.getParameter("size").toString()), 
        		Integer.parseInt(request.getParameter("rooms").toString()),
        		request.getParameter("name"));
        
        System.out.print(home.getName());
        System.out.print(home.getTaille());
        
        HomeAPI homeApi = new HomeAPI();
        homeApi.put(home);
      
        request.setAttribute("insertedHome", home);
        this.getServletContext().getRequestDispatcher("/homes/homes_post.jsp").forward(request, response);
        
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> persons = getListPerson();
        request.setAttribute("listPerson", persons);
        this.getServletContext().getRequestDispatcher("/homes/homes.jsp").forward(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("test");
		
	}

	private List<Person> getListPerson() {
		
        PersonAPI personInformation = new PersonAPI();
        List<Person> allInformationFromPersons = (List<Person>) personInformation.findAll();
        
		return allInformationFromPersons;
		
	}
	
	
	
}