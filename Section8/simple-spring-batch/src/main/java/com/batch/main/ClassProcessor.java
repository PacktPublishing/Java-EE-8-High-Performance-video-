package com.batch.main;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.batch.beans.Employee;

@Component("classProcesser")
public class ClassProcessor  implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee emp) throws Exception {
		System.out.println("Inside ClassProcessor..." + emp);
		return emp;
	}
	
}
