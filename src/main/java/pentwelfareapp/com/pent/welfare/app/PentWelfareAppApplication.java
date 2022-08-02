package pentwelfareapp.com.pent.welfare.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PentWelfareAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PentWelfareAppApplication.class, args);
	}
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String[] origins = {
						"http://localhost:4200"
				};
				registry.addMapping("/**").allowedOrigins(origins).allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH");
			}
		};
	}


}
