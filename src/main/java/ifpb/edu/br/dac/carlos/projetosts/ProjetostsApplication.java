package ifpb.edu.br.dac.carlos.projetosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ifpb.edu.br.dac.carlos.projetosts.business.service.SystemRoleService;

@SpringBootApplication
@EnableWebMvc
public class ProjetostsApplication implements WebMvcConfigurer, CommandLineRunner {
	
    @Autowired
    SystemRoleService systemRoleService;
    
	public static void main(String[] args) {
		SpringApplication.run(ProjetostsApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				.addMapping("/**")
				.allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH");
	}

    @Override
    public void run(String... args) throws Exception {
        systemRoleService.createDefaultValues();
    }

}
