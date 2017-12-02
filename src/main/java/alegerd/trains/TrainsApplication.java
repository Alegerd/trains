package alegerd.trains;

import alegerd.trains.entities.RouteEntity;
import alegerd.trains.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "alegerd.trains.repositories")
//@EntityScan("alegerd.trains.entities")
public class TrainsApplication implements CommandLineRunner{

	@Autowired
	private RouteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TrainsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception{
		System.out.println("Result --> " + repository.findAll());
	}
}
