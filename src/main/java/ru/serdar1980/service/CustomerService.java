package ru.serdar1980.service;

import java.util.List;

import ru.serdar1980.domain.Customer;

public interface CustomerService {
	List<Customer> getCustomerList(); 
	void saveUpdateCustomer(Customer customer);
	Customer getCustomer(Integer id);
	void deleteCustomer(Integer id);
}
