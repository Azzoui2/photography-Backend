package pho.ma.services;

import java.util.List;

import pho.ma.entities.Client;
import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;
import pho.ma.entities.Specialites;
import pho.ma.repositories.ReservationRepository;

public interface PersService {
	Personne savePersonne(Personne personne);

	List<Personne> listPersonnes();

	Reservation getReservation();

	List<Reservation> ListReservation();

	Reservation saveReservation(Reservation reservation);

	List<Specialites> ListSpecialites();

	// List<Specialites> listSpecialites();
	List<Personne> listClient();

	Personne saveClient(Client client);

	void deleteReservation(Long id);

	Reservation findById(Long id);

	List<Personne> personnesRecherch(String keyword);

}
