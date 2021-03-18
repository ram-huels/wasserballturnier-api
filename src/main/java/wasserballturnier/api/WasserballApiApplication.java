package wasserballturnier.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("wasserballturnier.api.persistence.mannschaft")

@SpringBootApplication
public class WasserballApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasserballApiApplication.class, args);
	}

}
