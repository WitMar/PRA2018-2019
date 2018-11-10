package hibernate;

import hibernate.model.Address;
import hibernate.model.Employee;
import hibernate.queries.Queries;

import javax.persistence.*;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            // FACTORY NAME HAS TO MATCHED THE ONE FROM PERSISTED.XML !!!
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Employee emp = new Employee();
            emp.setFirstName("Jan");
            emp.setLastName("Polak" + new Random().nextInt());
            emp.setSalary(100);
            emp.setPesel(new Random().nextInt());

            Address add = new Address();
            add.setCity("poznan");
            add.setHousenr("5");
            add.setNr("4");
            add.setPostcode("22321");
            add.setStreet("Norwida");

            emp.setAddress(add);

            entityManager.persist(add);
            entityManager.persist(emp);

            //Simple Query
            Employee employee = entityManager.find(Employee.class, emp.getId());
            if (employee == null) {
                System.out.println(emp.getId() + " not found! ");
            } else {
                System.out.println("Found " + employee);
            }

            System.out.println("Employee " + employee.getId() + " " + employee.getFirstName() + employee.getLastName());

            //User-defined query
            getThemAll(entityManager);
            changeFirstGuyToNowak(entityManager);

            //Pageable query
            for (int i = 1; i < 101; i++) {
                entityManager.persist(Employee.copyEmployee(emp));
            }
            entityManager.flush();
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            Queries query = new Queries(entityManager);
            List<Employee> resultByPage = query.getAllEmployeeByPage(1);
            resultByPage = query.getAllEmployeeByPage(2);
            entityManager.getTransaction().commit();

            //Illegal
            entityManager.getTransaction().begin();
            int id = employee.getId();
            entityManager.remove(employee);
            Employee emp2 = new Employee();
            emp2.setId(id);
            emp2.setFirstName("Marcin");
            emp2.setLastName("Wito" + new Random().nextInt());
            emp2.setSalary(100);
            emp2.setPesel(new Random().nextInt());
            entityManager.persist(emp2);
            entityManager.getTransaction().commit();

            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

    static void getThemAll(EntityManager entityManager)  {
        Query query = entityManager.createQuery("SELECT k FROM Employee k");

        List<Employee> result = query.getResultList();
        System.out.println("I got a person " + result.get(0).getFirstName());
    }

    static void changeFirstGuyToNowak(EntityManager entityManager) {

        List<Employee> employees = new Queries(entityManager).getEmployeeByName("Polak");

        employees.get(0).setLastName("NowakPRE" + new Random().nextInt());

    }

}