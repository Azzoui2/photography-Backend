package pho.ma;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

 
import pho.ma.entities.Personne;
import pho.ma.entities.Client;
import pho.ma.entities.Admin;
import pho.ma.entities.Photographe;
import pho.ma.entities.Reservation;
import pho.ma.entities.Reservation.Status;
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
            ReservationRepository reservationRepository,
            SpecialitesRepository specialitesRepository
   ) {

    	
    	 return args -> {
             // Création et enregistrement des spécialités
             Stream.of("Hassan", "Imane", "Mohamed").forEach(name -> {
                 Specialites specialites = new Specialites();
                 specialites.setNom(name);
                 specialitesRepository.save(specialites);
             });

             // Création et enregistrement des entités Client, Photographe et Admin
             Client client = new Client();
             client.setNom("Client1");
             personneRepository.save(client);

             Photographe photographe = new Photographe();
             photographe.setNom("Photographe1");
             personneRepository.save(photographe);

             Admin admin = new Admin();
             admin.setNom("Admin1");
             personneRepository.save(admin);

             // Création et enregistrement de la réservation
             Reservation reservation = new Reservation();
             reservation.setDate(new Date());
             reservation.setClient(client);
             reservation.setPhotographe(photographe);
             reservation.setAdmin(admin);
             reservation.setFinie(false);
             reservation.setType(Reservation.Status.EN_ATTENTE);
             reservationRepository.save(reservation);
         };
     }
    	
    	
    	
    	
//    	{
//            return args -> {
//                // Ajout de réservations
//                Client client = new Client();
//                client.setNom("Client1");
//                // Enregistrement du client en base de données
//                personneRepository.save(client);
//
//                Photographe photographe = new Photographe();
//                photographe.setNom("Photographe1");
//                // Enregistrement du photographe en base de données
//                personneRepository.save(photographe);
//
//                Admin admin = new Admin();
//                admin.setNom("Admin1");
//                // Enregistrement de l'admin en base de données
//                personneRepository.save(admin);
//
//                Reservation reservation = new Reservation();
//                reservation.setDate(new Date());
//                reservation.setClient(client);
//                reservation.setPhotographe(photographe);
//                reservation.setAdmin(admin);
//                reservation.setFinie(false);
//                reservation.setType(Status.ANNULEE);
//                // Enregistrement de la réservation en base de données
//                reservationRepository.save(reservation);
//            };
//        }
//    }
    
    	
    	
    	
    	
//
//        return args -> {
//            // Create and save Specialites entities
//            Stream.of("Hassan", "Imane", "Mohamed").forEach(name -> {
//                Specialites specialites = new Specialites();
//                specialites.setNom(name);
//                specialitesRepository.save(specialites);
//            });
//
//            // Create and save Personne entities
//            Stream.of("Hassan", "Imane", "Mohamed").forEach(name -> {
//                Personne personne = new Personne();
//                personne.setNom(name);
//                personne.setEmail(name + "@gmail.com"); // Corrected typo in email domain
//                personne.setId(UUID.randomUUID().toString());
//                personne.setPrenom("EL" + name);
//                personne.setMot_de_passe(name);
//                // personne.setDtype("Personne"); // Not needed with Spring Data JPA
//                personneRepository.save(personne);
//            });
//
//            // Create and save Reservation entities
//            reservationRepository.findAll().forEach(reservation -> {
//                Reservation newReservation = new Reservation();
//                newReservation.setDate(new Date());
//                newReservation.setFinie(false);
//                newReservation.setType(Status.ANNULEE);
//                // Set Admin and Client properties if needed
//                // newReservation.setAdmin(adminEntity);
//                // newReservation.setClient(clientEntity);
//                reservationRepository.save(newReservation);
//            });
//        };
//    }
}
