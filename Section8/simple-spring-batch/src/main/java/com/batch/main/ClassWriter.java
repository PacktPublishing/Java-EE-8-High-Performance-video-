package com.batch.main;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import com.batch.beans.Employee;

@Component("classWriter")
public class ClassWriter implements ItemWriter<Employee> {
	
	@Override
	public void write(List<? extends Employee> arg0) throws Exception {
		
		System.out.println("Inside ClassWriter..." + arg0);
		System.exit(0);//interrupt flow.
	}

}
