package com.jnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		StudentDao dao= context.getBean(StudentDao.class);
		
		Student rahul = new Student();
		rahul.setSid(1004);
		rahul.setSname("Rahul3 Sharma3");
		rahul.setMarks(234);
		
		//dao.saveStudent(rahul);
		dao.selectStudent();
		

	}

}
