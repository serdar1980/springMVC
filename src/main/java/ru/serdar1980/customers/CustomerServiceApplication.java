package ru.serdar1980.customers;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.serdar1980")
@EntityScan("ru.serdar1980.domain")
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=(ApplicationContext) SpringApplication.run(CustomerServiceApplication.class, args);
		
//		System.out.println(ctx.getBeanDefinitionCount());
//		
//		for(String name: ctx.getBeanDefinitionNames()){
//		//	System.out.println(name);
//		}
	}
}
