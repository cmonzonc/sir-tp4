package api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import opower.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        GeneralQueries test = new GeneralQueries(manager);
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        try {
        	/*
            test.createHome(234.0, 3, "Carlos' Home", "Charles", "Foulon", "charles@gmail.com");
            test.createHome(134.5, 3, "Malaine' Home", "Malaine", "Doré", "malaine@gmail.com");
            test.createHome(466.4, 3, "Antoine' Home", "Antoine", "Macron", "antoine@gmail.com");
            test.createHome(340.0, 3, "Carontin' Home", "Carontin", "Queguiner", "carontin@gmail.com");
            test.createElectronicDevice("Microwave", 1000, manager.find(Person.class, 1));
            test.createHeater("Living Room", 1500, manager.find(Home.class, 1));
            test.createHeater("Room", 2500, manager.find(Home.class, 2));
            */
        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();

        // test.listHomes();
        // test.listPerson();
        test.listElectronicDevice();
        test.listHeater();
        test.getPersonById(2);
        test.getHomeById(2);
        manager.close();
        testPersonDao();
        System.out.println(".. done");
    }

    public static void testPersonDao() {

    		// Create persons
        PersonAPI dao = new PersonAPI();
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
        dao.put(person);
        person = (Person) dao.get(person.getId());
        
        // Showing information
        System.out.println(person.toString());
        
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
