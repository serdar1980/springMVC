package ru.serdar1980.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.serdar1980.domain.Customer;
import ru.serdar1980.domain.Product;
import ru.serdar1980.repository.ProductRepository;
@Service(value="customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
	
	
	
	private Map<Integer, Customer> customers = new HashMap<>(); 
	
	public CustomerServiceImpl(){
		
		loadCustomers();
	}

	@Override
	public List<Customer> getCustomerList() {
	
		return new ArrayList<>(customers.values());
	}
	
	private Integer getNextId(){
		Set keys = customers.keySet();
		if(keys == null || keys.isEmpty()){
			return 1;
		}
		
		return (Integer)Collections.max(keys)+1;
	}
	
	private void loadCustomers() {
		Customer c1 = new Customer();
		c1.setId(getNextId());
		c1.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customers.put(c1.getId(), c1);
		
		Customer c2 = new Customer();
		c2.setId(getNextId());
		c2.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customers.put(c2.getId(), c2);
		/*
		Customer c3 = new Customer();
		c3.setId(getNextId());
		c3.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customers.put(c3.getId(), c3);
		
		
		Customer c4 = new Customer();
		c4.setId(getNextId());
		c4.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customers.put(c4.getId(), c4);
		
		Customer c5 = new Customer();
		c5.setId(getNextId());
		c5.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customers.put(c5.getId(), c5);
		*/
	}

	@Override
	public void saveUpdateCustomer(Customer customer) {
		if(customer.getId()==null){
			customer.setId(getNextId());
		}
		customers.put(customer.getId(), customer);
	}

	@Override
	public Customer getCustomer(Integer id) {
		return customers.get(id);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customers.remove(id);
	}
}
