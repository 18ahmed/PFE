




package com.sopra.project;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sopra.project.controller.InstalModController;


@SpringBootApplication
@EnableScheduling
public class main  {
	
	
	

	public static void main(String[] args) {
		
		InstalModController insta = new InstalModController();
	       
		SpringApplication.run(main.class, args);
		
		
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
		
	}
	
}
