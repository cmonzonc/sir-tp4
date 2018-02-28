package servlet;

import java.io.*;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.*;

import opower.*;

@WebServlet(
	    name = "user",
	    urlPatterns = { "/user" }
	)
public class UserInfo extends HttpServlet {

	private static final long serialVersionUID = -643940801337147365L;

	public void createPerson(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");
        String mail = request.getParameter("mail");

        System.out.println("-> " + name);

        PersonAPI dao = new PersonAPI();

        dao.put(new Person(name, firstname, mail));
    }

    @Override
    public void destroy() {
        try {}
        catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            api.LocalEntityManagerFactory.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Person> persons = getListPerson();
        request.setAttribute("listPerson", persons);
        this.getServletContext().getRequestDispatcher("/listperson.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createPerson(request, response);
        response.sendRedirect("/");
    }

    @Override
    public void init() {
        try {
        		api.LocalEntityManagerFactory.getInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Person> getListPerson() {
        PersonAPI dao = new PersonAPI();

        return (List<Person>) dao.findAll();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}