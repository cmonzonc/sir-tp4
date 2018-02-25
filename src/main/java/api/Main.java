package api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import opower.*;
import services.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
    		System.out.println("Creating services:");
        testPersonDao();
        System.out.println("Done.");
        System.out.println("Executing queries:");
        testingServices();
        System.out.println("Done.");
    }

    @SuppressWarnings("unchecked")
    public static void testPersonDao() {

        // Create persons
        CommandAPI personQueries = new PersonAPI();
        Person person = new Person("Christian", "Monzón", "christian@telemetrio.com");

        // Create friends
        List<Person> friends = new ArrayList<Person>();
        Person friend1 = new Person("Carl", "Sagan", "carl@nasa.com");
        Person friend2 = new Person("Neil", "Tyson", "neil@nasa.com");

        // Adding friends
        friends.add(friend1);
        friends.add(friend2);

        // Set friends
        person.setFriends(friends);
        personQueries.put(person);
        person = (Person) personQueries.get(person.getId());

        // Showing information
        System.out.println(person.getId());

        CommandAPI homeQueries = new HomeAPI();
        List<Home> homes = new ArrayList<Home>();
        Home home = new Home(12.23, 2, "Christian's home");

        homes.add(home);
        home.setPerson(person);

        Heater heating = new Heater("Living room 1", 1600, "watts", "Living");
        ElectronicDevice electronic = new ElectronicDevice("Hi-Fi Audio System", 1600, "Kwh");

        electronic.setPerson(person);

        // home.getHeater().add((Heater) heating);
        home.getDevice().add(heating);
        home.getDevice().add(electronic);
        homeQueries.put(home);
    }
    
    public static void testingServices() {
    	
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        GeneralQueries test = new GeneralQueries(manager);
        HomeServices testHome = new HomeServices(manager);
        DeviceServices testDevice = new DeviceServices(manager);
        PersonServices testPerson = new PersonServices(manager);
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        try {

            // testDevice.listElectronicDevice();
            // testDevice.listHeater();
            // 
            // testPerson.getPersonById(2);
            // testHome.getHomeById(2);
        	testPerson.getPersons();
        		testPerson.getPersonByIdentifier(1);
        		
        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();

        // test.listHomes();
        // test.listPerson();

        manager.close();
    	
    	
    }
    
    
}