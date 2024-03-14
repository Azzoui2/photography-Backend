package pho.ma.services;
 
 

import java.util.List;

import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;
import pho.ma.repositories.ReservationRepository;
 public interface PersService {
	 Personne savePersonne(Personne personne);
     List<Personne> listPersonnes();
     
     Reservation savareservation();
     Reservation getReservation();
     
}
