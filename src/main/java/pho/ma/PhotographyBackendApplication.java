package pho.ma;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pho.ma.entities.Personne;
import pho.ma.entities.Client;
import pho.ma.entities.Admin;
import pho.ma.entities.Photographe;
import pho.ma.entities.Specialites;
import pho.ma.repositories.PersonneRepository;
import pho.ma.repositories.ReservationRepository;
import pho.ma.repositories.SpecialitesRepository;
 
@SpringBootApplication
public class PhotographyBackendApplication {

 public static void main(String[] args) {
     SpringApplication.run(PhotographyBackendApplication.class, args);
 }

 @Bean
 CommandLineRunner start(
     PersonneRepository personneRepository,
     ReservationRepository reservaRepository,
     SpecialitesRepository specialitesRepository
 ) {
	 
//	 return args -> {
//         Stream.of("Hassan", "Imane", "Mohamed").forEach(name -> {
//             Specialites specialites = new Specialites();
//             specialites.setNom(name);
//             specialitesRepository.save(specialites);
//           
//         });
//     };
	 
     return args -> {
         Stream.of("Hassan", "Imane", "Mohamed").forEach(name -> {
             Personne personne = new Personne();
             personne.setNom(name);
             personne.setEmail(name + "@gamil.com");
             
             personne.setPrenom("EL" + name);
             personne.setMot_de_passe(name);
           // personne.setDtype("Personne"); // Spécifiez la valeur du discriminant
             personneRepository.save(personne);
         });
     };
 }
}
