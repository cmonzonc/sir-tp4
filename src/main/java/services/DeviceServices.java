package services;

import java.util.List;

import javax.persistence.EntityManager;

import opower.ElectronicDevice;
import opower.Heater;

public class DeviceServices extends GeneralQueries {

    public DeviceServices(EntityManager manager) {
		super(manager);
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

    public void createElectronicDevice(String name, Integer consumption, String unit) {
        ElectronicDevice electronicDevice = new ElectronicDevice(name, consumption, unit);

        electronicDevice.setName("Microwave");

        // if (person != null) {
        // electronicDevice.setPerson(person);
        // }
        manager.persist(electronicDevice);
    }

    public void createHeater(String name, Integer power, String unit, String place) {
        Heater heater = new Heater(name, power, unit, place);

        heater.setName("Microwave");

        // if (home != null) {
        // heater.setHome(home);
        // }
        manager.persist(heater);
    }
    
}
