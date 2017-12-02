package alegerd.trains;

import alegerd.trains.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "alegerd.trains.repositories")
//@EntityScan("alegerd.trains.entities")
public class TrainsApplication{

	@Autowired
	private RouteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TrainsApplication.class, args);
	}

}
