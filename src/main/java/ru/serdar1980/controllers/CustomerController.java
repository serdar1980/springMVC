package ru.serdar1980.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.serdar1980.domain.Customer;
import ru.serdar1980.service.CustomerService;
@Controller
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	@Qualifier("customServiceJpaDaoImpl")
	public void setCustomerService(CustomerService customerService){
		this.customerService = customerService;
	}
	
	
	@RequestMapping("/customers")
	public String getListCustomers(Model model){
		model.addAttribute("customers", customerService.getCustomerList());
		return "customers";
	}
	
	@RequestMapping("/customer/new")
	public String createCustomer(Model model){
		model.addAttribute("customer", new Customer());
		return "customerform";
	}
	
	@RequestMapping("/customer/edit/{id}")
	public String updateCustomer(@PathVariable Integer id, Model model){
		model.addAttribute("customer", customerService.getCustomer(id));
		return "customerform";
	}
	
	@RequestMapping("/customer/{id}")
	public String viewCustomer(@PathVariable Integer id, Model model){
		model.addAttribute("customer", customerService.getCustomer(id));
		return "customerview";
	}
	@RequestMapping("/customer/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id, Model model){
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}
	
	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public String saveOrUpdateCustomers(Customer customer){
		customerService.saveUpdateCustomer(customer);
		return "redirect:/customers";
	}
	
}
