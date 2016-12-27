package ru.serdar1980.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.h2.command.ddl.CreateAggregate;
import org.springframework.stereotype.Service;

import ru.serdar1980.domain.Customer;
import scala.annotation.varargs;

@Service(value="customServiceJpaDaoImpl")
public class CustomServiceJpaDaoImpl implements CustomerService {

	private EntityManagerFactory emf;
	
	
	@Override
	public List<Customer> getCustomerList() {
		EntityManager em =  emf.createEntityManager();
		List<Customer> result =  (List<Customer>)em.createQuery("from Customer").getResultList();
		return result;
	}

	@Override
	public void saveUpdateCustomer(Customer customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}

	@Override
	public Customer getCustomer(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Customer.class, id);
	}

	@Override
	public void deleteCustomer(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Customer.class, id));
		em.getTransaction().commit();		
	}

	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
