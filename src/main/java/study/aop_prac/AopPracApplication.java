package study.aop_prac;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopPracApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(MyService myService) {
		return args -> {
			myService.doSomething();
		};
	}

}
