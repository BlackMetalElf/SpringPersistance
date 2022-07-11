package com.server.reactive;

import com.server.reactive.domain.entities.ContractType;
import com.server.reactive.domain.repositories.ContractTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DemoApplication.class);
		application.run(args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ContractTypeRepository contractTypeRepository){
		return args->{
			ContractType contactType=new ContractType("Permament","From Monday");
			contractTypeRepository.save(contactType);
		};
	}
}

