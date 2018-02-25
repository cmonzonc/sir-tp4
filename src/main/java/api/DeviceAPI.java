package api;

import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import opower.Device;

public class DeviceAPI implements CommandAPI<Device> {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    Device device;

    public DeviceAPI() {
        entityManager = LocalEntityManagerFactory.getInstance();
        entityTransaction = entityManager.getTransaction();
    }

    public Collection<Device> findAll() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> query = criteria.createQuery(Device.class);
        Root<Device> device = query.from(Device.class);
        CriteriaQuery<Device> queryDevice = query.select(device);

        return entityManager.createQuery(queryDevice).getResultList();
    }

    public boolean put(Device entity) {
        if (entity != null) {
            try {
                entityTransaction.begin();
                entityManager.persist(entity);
                entityTransaction.commit();

                return true;
            } catch (Exception e) {
                System.out.println("Exception occurred");

                return false;
            }
        } else {
            return false;
        }
    }

    public Device remove(Device identifier) {
        device = entityManager.getReference(Device.class, identifier);

        if (device != null) {
            entityTransaction.begin();
            entityManager.remove(device);
            entityTransaction.commit();
        }

        return device;
    }

    public Device update(Device entity) {
        if (entity != null) {
            entityTransaction.begin();
            entityManager.merge(entity);
            entityTransaction.commit();
        }

        return entity;
    }

    public Device get(Object identifier) {
        if (identifier == null) {
            throw new IllegalArgumentException("The argument cannot be null");
        } else {
            device = (Device) (entityManager.find(Device.class, identifier));
        }

        return device;
    }
}