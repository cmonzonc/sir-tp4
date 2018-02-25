package api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import opower.ElectronicDevice;
import opower.Heater;
import opower.Home;
import opower.Person;

public class GeneralQueries {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    private EntityManager manager = factory.createEntityManager();

    public GeneralQueries(EntityManager manager) {
        this.manager = manager;
    }

    public void createElectronicDevice(String name, Integer consumption, String unit) {
        ElectronicDevice electronicDevice = new ElectronicDevice(name, consumption, unit);

        electronicDevice.setName("Microwave");

        //if (person != null) {
        //    electronicDevice.setPerson(person);
        //}

        manager.persist(electronicDevice);
    }

 
	
	   public void createHeater(String name, Integer power, String unit, String place) {
	        Heater heater = new Heater(name, power, unit, place);
	        
	        heater.setName("Microwave");

	        //if (home != null) {
	        //    heater.setHome(home);
	        //}

	        manager.persist(heater);
	        
	    }

	    public void createHome(Double size, Integer pieces, String name, String name_person, String surname_person,
	                           String mail) {

	        // int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
	        // if (numOfEmployees == 0) {
	        Person person;

	        person = createPerson(name_person, surname_person, mail);

	        // Home home = new Home(size, pieces, name, person);

	        // manager.persist(home);
	    }

	    public Person createPerson(String name, String surname, String mail) {
	        Person person = new Person(name, surname, mail);

	        manager.persist(person);

	        return person;
	    }

	    public void listElectronicDevice() {
	        List<ElectronicDevice> resultList = manager.createQuery("Select d FROM ElectronicDevice d WHERE DTYPE = :type",
	                                                                ElectronicDevice.class)
	                                                   .setParameter("type", "ElectronicDevice")
	                                                   .getResultList();

	        System.out.println("Number of electronic devices: " + resultList.size());

	        for (ElectronicDevice next : resultList) {
	            System.out.println("ElectronicDevice: " + next.getId() + next.getConsumption());
	        }
	    }

	    public void listHeater() {
	        List<Heater> resultList = manager.createQuery("Select p FROM Heater p WHERE DTYPE = :type", Heater.class)
	                                         .setParameter("type", "Heater")
	                                         .getResultList();

	        System.out.println("Number of heaters: " + resultList.size());

	        for (Heater next : resultList) {
	            System.out.println("Heater: " + next.getId());
	        }
	    }

	    public void listHomes() {
	        List<Home> resultList = manager.createQuery("Select a From Home a", Home.class).getResultList();

	        System.out.println("Number of houses: " + resultList.size());

	        for (Home next : resultList) {
	            System.out.println("Home: " + next.getId() + next.getName() + next.getPieces() + next.getTaille());
	        }
	    }

	    public void listPerson() {
	        List<Person> resultList = manager.createQuery("Select p FROM Person p", Person.class).getResultList();

	        System.out.println("Number of person: " + resultList.size());

	        for (Person next : resultList) {
	            System.out.println("Person: " + next.getId() + next.getName() + next.getSurname() + next.getEmail());
	        }
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

	    public void getPersonById(Integer idUser) {
	        List<Person> resultById = manager.createQuery("Select p FROM Person p WHERE id = :idUser", Person.class)
	                                         .setParameter("idUser", idUser)
	                                         .getResultList();

	        System.out.println("Number of rows returned: " + resultById.size());

	        for (Person next : resultById) {
	            System.out.println("Person with ID " + next.getId() + next.getName() + next.getSurname());
	        }
	    }

	    public void getElectronicDeviceById() {}

	    public void getHeaterById() {}
	    
}
