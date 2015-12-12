package pl.codesphere.spring.boot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan("pl.codesphere.spring.boot.domain")
@EnableJpaRepositories("pl.codesphere.spring.boot.repository")
@ComponentScan(basePackages = { "pl.codesphere.spring.boot.config", "pl.codesphere.spring.boot.web",
		"pl.codesphere.spring.boot.service" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}