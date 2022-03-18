package com.weather.Tracking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrackingApplication.class, args);
	}

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
