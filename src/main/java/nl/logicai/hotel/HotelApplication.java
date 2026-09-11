package nl.logicai.hotel;

import nl.logicai.hotel.models.Gast;
import nl.logicai.hotel.models.Kamer;
import nl.logicai.hotel.repositories.GastRepository;
import nl.logicai.hotel.repositories.KamerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

	@Bean
	CommandLineRunner seed(GastRepository gastRepository, KamerRepository kamerRepository) {
		return args -> {
			Gast ron = new Gast("Ron", "ron@example.com", "0612345678");
			Gast anna = new Gast("Anna", "anna@example.com", "0623456789");
			Gast test = new Gast("test", "test@gmail.com", "0634424243" );
			Gast lois = new Gast("Lois","lois@gmail.com", "0643543223");

			gastRepository.save(ron);
			gastRepository.save(anna);
			gastRepository.save(test);
			gastRepository.save(lois);

			Kamer kamer101 = new Kamer(101, "eenpersoons", 69.50, 1, 1);
			Kamer kamer102 = new Kamer(102, "tweepersoons", 99.95, 2,1);
			Kamer kamer201 = new Kamer(201, "suite", 189.00, 4,2);
			Kamer kamer99 = new Kamer(99, "suite", 99.00, 2,0);

			kamerRepository.save(kamer101);
			kamerRepository.save(kamer102);
			kamerRepository.save(kamer201);
			kamerRepository.save(kamer99);
		};
		// Overzicht can i find on index.html
		// fragments = nav
		// gast-formulier = form
        //
	}
}
