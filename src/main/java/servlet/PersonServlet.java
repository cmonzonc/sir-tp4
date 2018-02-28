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
        String personName = request.getParameter("name");
        Person person = new Person();

        person.setName(personName);

        PersonAPI personApi = new PersonAPI();

        personApi.put(person);
        out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath()
                    + "/styles/style.css' />");
        out.println("<HTML>\n<BODY>\n" + "<H1>Person inserted on DB</H1>\n" + "<UL>\n" + " <LI>Nom: " + personName
                    + "</UL>\n" + "</BODY></HTML>");
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Person> persons = getListPerson();
        request.setAttribute("listPerson", persons);
        this.getServletContext().getRequestDispatcher("/persons.jsp").forward(request, response);
		
		PrintWriter out = response.getWriter();
		out.println("test");
		
	}

	private List<Person> getListPerson() {
		
        PersonAPI personInformation = new PersonAPI();
        List<Person> allInformationFromPersons = (List<Person>) personInformation.findAll();
        
		return allInformationFromPersons;
		
	}
	
	
	
}