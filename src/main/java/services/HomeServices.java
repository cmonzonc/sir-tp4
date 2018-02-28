package services;

import java.util.List;

import javax.persistence.EntityManager;

import opower.Home;
import opower.Person;

public class HomeServices extends GeneralQueries {


    public HomeServices() {
		super();
	}




	public void createHome(Double size, Integer pieces, String name, String name_person, String surname_person,
                           String mail) {

        // int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
        // if (numOfEmployees == 0) {
        Person person;

        //person = createPerson(name_person, surname_person, mail);

        // Home home = new Home(size, pieces, name, person);
        // manager.persist(home);
    }




    public List<Home> listHomes() {
    	
        List<Home> resultList = manager.createQuery("Select a From Home a", Home.class).getResultList();
        return resultList;
        
    }
	
    public void getHomeById(Integer idHome) {
        List<Home> resultById = manager.createQuery("Select h FROM Home h WHERE id = :idHome", Home.class)
                                       .setParameter("idHome", idHome)
                                       .getResultList();

        System.out.println("Number of rows returned: " + resultById.size());

        for (Home next : resultById) {
            System.out.println("Home with ID " + next.getId() + next.getPieces());
        }
    }

    
}
