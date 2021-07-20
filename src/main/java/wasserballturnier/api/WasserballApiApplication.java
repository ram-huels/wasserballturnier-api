package wasserballturnier.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WasserballApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasserballApiApplication.class, args);
	}

}
