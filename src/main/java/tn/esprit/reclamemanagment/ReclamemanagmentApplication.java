package tn.esprit.reclamemanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "tn.esprit.reclamemanagment.repository.*")
@EntityScan("tn.esprit.reclamemanagment.repository.*")
@SpringBootApplication
@ComponentScan(basePackages = "tn.esprit.reclamemanagment.repository.*")
public class ReclamemanagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamemanagmentApplication.class, args);
	}

}
