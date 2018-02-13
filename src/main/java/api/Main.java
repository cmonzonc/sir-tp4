package api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import opower.*;
import jpa.*;

public class Main {

	
	private EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("mysql");
	private EntityManager manager = factory.createEntityManager();
	
	public Main(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory =   
	 			 Persistence.createEntityManagerFactory("mysql");
			EntityManager manager = factory.createEntityManager();
			Main test = new Main(manager);
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
			//test.listHomes();
			//test.listPerson();
			test.listElectronicDevice();
			test.listHeater();
			test.getPersonById(2);
			test.getHomeById(2);
			
				
	   	 manager.close();
			System.out.println(".. done");
		
	}
	
	private Person createPerson(String name, String surname, String mail) {
		
		Person person = new Person(name, surname, mail);
		manager.persist(person);
		
		return person;
		
	}
	
	public void createHome(Double size, Integer pieces, String name, String name_person, String surname_person, String mail) {

		// int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		// if (numOfEmployees == 0) {
		
		Person person;
		person = createPerson(name_person, surname_person, mail);
		Home home = new Home(size, pieces, name, person);
		manager.persist(home);
			
	}
	
	
	private void createHeater(String name, Integer power, Home home) {

		Heater heater = new Heater(name, power, home);
		heater.setName("Microwave");
		
		if(home != null) {
			heater.setHome(home);	
		}
		manager.persist(heater);
		
	}
	
	private void createElectronicDevice(String name, Integer consumption, Person person) {
		
		ElectronicDevice electronicDevice = new ElectronicDevice(consumption);
		electronicDevice.setName("Microwave");
		
		if(person != null) {
			electronicDevice.setPerson(person);	
		}
		manager.persist(electronicDevice);
		
	}

	private void listHomes() {
		
		List<Home> resultList = manager.createQuery("Select a From Home a", Home.class).getResultList();
		System.out.println("Number of houses: " + resultList.size());
		for (Home next : resultList) {
			System.out.println("Home: " + next.getId() + next.getName() + next.getPieces() + next.getTaille());
		}
	}
	
	private void listElectronicDevice() {
		
		List<ElectronicDevice> resultList = manager.createQuery("Select d FROM ElectronicDevice d WHERE DTYPE = :type", ElectronicDevice.class).setParameter("type", "ElectronicDevice").getResultList();
		System.out.println("Number of electronic devices: " + resultList.size());
		for(ElectronicDevice next : resultList) {
			System.out.println("ElectronicDevice: " + next.getId() + next.getConsumption() );
		}
	}

	private void listHeater() {
		
		List<Heater> resultList = manager.createQuery("Select p FROM Heater p WHERE DTYPE = :type", Heater.class).setParameter("type", "Heater").getResultList();
		System.out.println("Number of heaters: " + resultList.size());
		for(Heater next : resultList) {
			System.out.println("Heater: " + next.getId());
		}
	}
	
	private void listPerson() {
		
		List<Person> resultList = manager.createQuery("Select p FROM Person p", Person.class).getResultList();
		System.out.println("Number of person: " + resultList.size());
		for(Person next : resultList) {
			System.out.println("Person: " + next.getId() + next.getName() + next.getSurname() + next.getEmail() );
		}
	}
	
	
	private void getPersonById(Integer idUser) {
		
		List<Person> resultById = manager.createQuery("Select p FROM Person p WHERE id = :idUser", Person.class).setParameter("idUser", idUser).getResultList();
		System.out.println("Number of rows returned: " + resultById.size());
		
		for(Person next : resultById) {
			System.out.println("Person with ID " + next.getId() + next.getName() + next.getSurname());
		}
		
	}

	private void getHomeById(Integer idHome) {

		List<Home> resultById = manager.createQuery("Select h FROM Home h WHERE id = :idHome", Home.class).setParameter("idHome", idHome).getResultList();
		System.out.println("Number of rows returned: " + resultById.size());
		
		for(Home next : resultById) {
			System.out.println("Home with ID " + next.getId() + next.getPieces());
		}
		
	}
	
	private void getElectronicDeviceById() {
		
	}
	
	private void getHeaterById() {
		
	}
	
	
}
