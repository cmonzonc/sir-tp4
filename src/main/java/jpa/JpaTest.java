package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


	public class JpaTest {
		
		private EntityManager manager;
		private EntityManager entityManager;
		public JpaTest(EntityManager manager) {
			this.manager = manager;
		}
		/**
		 * 	@param args
	 */
		public static void main(String[] args) {
			EntityManagerFactory factory =   
 			 Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEmploy("carlos", "tools");
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listEmployees();
			
   	 manager.close();
		System.out.println(".. done");
	}
	private void createEmploy(String name, String department) {
		// int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		// if (numOfEmployees == 0) {
			Department departmentObject; 
			departmentObject = createDepartment(department);
			Employee employee = new Employee(name, departmentObject);
			manager.persist(employee);
			
		// }
	}
	
	
	private Department createDepartment(String name) {
		
		Department department = new Department(name);
		manager.persist(department);
		
		return department;
		
	}
	
	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}

}
