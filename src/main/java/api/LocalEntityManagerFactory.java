package api;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class LocalEntityManagerFactory {
    private static String persistence_unit_name = "mysql";
    private static EntityManagerFactory emf;
    private static javax.persistence.EntityManager em;

    private LocalEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory(persistence_unit_name);
        em = emf.createEntityManager();
    }

    public static void close() {
        em.close();
        emf.close();
    }

    public static synchronized javax.persistence.EntityManager getInstance() {
        if (em == null) {
            new LocalEntityManagerFactory();
        }

        return em;
    }

    public static String getPersistenceUnitName() {
        return LocalEntityManagerFactory.persistence_unit_name;
    }

    public static void setPersistenceUnitName(String persistence_unit_name) {
        LocalEntityManagerFactory.persistence_unit_name = persistence_unit_name;
    }
}