package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.PersonAPI;
import opower.Person;

@WebServlet(
    name = "person",
    urlPatterns = { "/person" }
)
public class PersonServlet extends HttpServlet {

	private static final long serialVersionUID = 460411854431572476L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Person person = new Person();

        person.setName(request.getParameter("firstname"));
        person.setSurname(request.getParameter("lastname"));
        person.setEmail(request.getParameter("email"));
        
        PersonAPI personApi = new PersonAPI();
        personApi.put(person);
      
        request.setAttribute("insertedPerson", person);
        this.getServletContext().getRequestDispatcher("/persons/persons_post.jsp").forward(request, response);
        
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> persons = getListPerson();
        request.setAttribute("listPerson", persons);
        this.getServletContext().getRequestDispatcher("/persons/persons.jsp").forward(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("test");
		
	}

	private List<Person> getListPerson() {
		
        PersonAPI personInformation = new PersonAPI();
        List<Person> allInformationFromPersons = (List<Person>) personInformation.findAll();
        
		return allInformationFromPersons;
		
	}
	
	
	
}