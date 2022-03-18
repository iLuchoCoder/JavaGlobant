package com.meteorological.tracking;

import com.meteorological.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.meteorological.models")
@ComponentScan("com.meteorological.*")
@EnableJpaRepositories("com.meteorological.repository")
@SpringBootApplication
public class ApplicationSB implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationSB.class, args);
	}

	@Autowired
	private TemperatureRepository repoInitial;

	@Override
	public void run(String... args) throws Exception {
		/*Date date1 = new Date();
		Temperature t1 = new Temperature(date1, (float) 3.41765, (float) -76.5461, "Cali", "Valle del Cauca", "Colombia", (float) 25.12);
		repoInitial.save(t1);

		Date date2 = new Date();
		Temperature t2 = new Temperature(date2, (float) 6.23631, (float) -75.5887, "Medellin", "Antioquia", "Colombia", (float) 18.32);
		repoInitial.save(t2);*/
	}
}


