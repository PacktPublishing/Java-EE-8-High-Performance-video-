package com.batch.main;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;
import com.batch.beans.Employee;

@Component("classReader")
public class ClassReader implements ItemReader<Employee> {

	@Override
	public Employee read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		Employee emp=new Employee();
		//Set values in Employee object
		emp.setEmpId("123456");
		emp.setName("Manohar");
		System.out.println("Inside ClassReader..." + emp);
		return emp;
	}
}
