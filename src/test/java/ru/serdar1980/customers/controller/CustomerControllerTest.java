package ru.serdar1980.customers.controller;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ru.serdar1980.controllers.CustomerController;
import ru.serdar1980.domain.Customer;
import ru.serdar1980.service.CustomerService;

public class CustomerControllerTest {

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private CustomerController customerController;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		//InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        ///viewResolver.setPrefix("/WEB-INF/resources/templates/");
        //viewResolver.setSuffix(".html");\
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates");
		
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController)
				.setViewResolvers(viewResolver)
				.build();
	}
	
	@Test
	public void testList() throws Exception{
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer());
		customers.add(new Customer());
		
		when(customerService.getCustomerList()).thenReturn((List)customers);
		mockMvc.perform(get("/customers"))
			   .andExpect(status().isOk())
			   .andExpect(view().name("customers"))
			   .andExpect(model().attribute("customers", hasSize(2)));
	}

	@Test
	public void testNewCustomer() throws Exception{
		
		verifyZeroInteractions(customerService);
		
		mockMvc.perform(get("/customer/new"))
			   .andExpect(status().isOk())
			   .andExpect(view().name("customerform"))
			   .andExpect(model().attribute("customer", instanceOf(Customer.class)));
	}
	
	@Test
	public void testEditCustomer() throws Exception{
		Integer id=1;
		when(customerService.getCustomer(id)).thenReturn(new Customer());
		
		mockMvc.perform(get("/customer/edit/1"))
			   .andExpect(view().name("customerform"))
			   .andExpect(model().attribute("customer", instanceOf(Customer.class)));
	}
	
	@Test
	public void testViewCustomer() throws Exception{
		
		Integer id =1;
		when(customerService.getCustomer(id)).thenReturn(new Customer());
		
		mockMvc.perform(get("/customer/1"))
		   .andExpect(view().name("customerview"))
		   .andExpect(model().attribute("customer", instanceOf(Customer.class)));
		
	}
	
	
}
