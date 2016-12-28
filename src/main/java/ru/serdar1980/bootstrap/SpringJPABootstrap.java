package ru.serdar1980.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ru.serdar1980.domain.Customer;
import ru.serdar1980.service.CustomerService;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private CustomerService customerService;

	@Autowired
	@Qualifier("customServiceJpaDaoImpl")
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		loadCustomers();
	}
	
	
	private void loadCustomers() {
		Customer c1 = new Customer();
		
		c1.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customerService.saveUpdateCustomer(c1);
		
		Customer c2 = new Customer();
		
		c2.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customerService.saveUpdateCustomer(c2);
		
		Customer c3 = new Customer();

		c3.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customerService.saveUpdateCustomer(c3);
		
		
		Customer c4 = new Customer();

		c4.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customerService.saveUpdateCustomer(c4);
		
		Customer c5 = new Customer();

		c5.buildSetFirstName("first Name").buildSetLastName("Last Name").buildSetEmail("@")
		.buildSetCity("City").buildSetAddressFirst("AddressFirst")
		.buildSetAddressSecond("AddressSecond").buildSetState("State").buildSetZipCode("Code");
		
		customerService.saveUpdateCustomer(c5);
		
		
	}
}
