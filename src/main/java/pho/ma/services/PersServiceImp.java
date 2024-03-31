package pho.ma.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pho.ma.entities.Client;
import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;
import pho.ma.entities.Specialites;
import pho.ma.repositories.PersonneRepository;
import pho.ma.repositories.ReservationRepository;
import pho.ma.repositories.SpecialitesRepository;

@Service
@Transactional
@AllArgsConstructor
@Slf4j

public class PersServiceImp implements PersService {

	private PersonneRepository personneRepository;

	private ReservationRepository reservationRepository;

	private SpecialitesRepository specialitesRepository;

	// Logger log= LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public Personne savePersonne(Personne personne) {
		log.info("Sauvgarder nouvelle clinet");
		Personne savePersonne = personneRepository.save(personne);

		return savePersonne;
	}

	@Override
	public Client saveClient(Client client) {
		log.info("Sauvgarder nouvelle clinet");
		Client savePersonne = personneRepository.save(client);

		return savePersonne;
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		log.info("Sauvgarder nouvelle reservation");
		Reservation saveReservation = reservationRepository.save(reservation);

		return saveReservation;
	}

	@Override
	public List<Personne> listPersonnes() {
		// TODO Auto-generated method stub
		return personneRepository.findAll();

	}

	@Override
	public List<Personne> listClient() {
		List<Personne> clients = new ArrayList<>();

		List<Personne> toutesLesPersonnes = personneRepository.findAll();

		for (Personne personne : toutesLesPersonnes) {
			if (personne instanceof Client) {
				clients.add(personne);
			}
		}

		return clients;
	}

	@Override
	public List<Reservation> ListReservation() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public List<Specialites> ListSpecialites() {
		// TODO Auto-generated method stub
		return specialitesRepository.findAll();
	}

	@Override
	public Reservation getReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}

	@Override
	public Reservation findById(Long id) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(id).orElse(null);
	}

	@Override
	public List<Client> personnesRecherch(String keyword) {
		// Rechercher les personnes dont le nom contient le mot-clé
		List<Client> personnes = personneRepository.findByNomContains(keyword);

		// Collecter les résultats filtrés
		List<Client> personnesFiltrees = personnes.stream()
				// Filtrez les personnes dont le nom contient le mot-clé (ignorez la casse)
				.filter(personne -> personne.getNom().toLowerCase().contains(keyword.toLowerCase()))
				// Collectez les résultats filtrés dans une nouvelle liste
				.collect(Collectors.toList());

		// Retourner la liste des personnes filtrées
		return personnesFiltrees;
	}

	// @Override
	// public List<Personne> personnesRecherch(String keyword) {

	// List<Personne> personnes = personneRepository.findByNomContains(keyword);

	// return personnes;
	// }
	// @Override
	// public boolean checkIfEmailExists(String email) {
	// log.info("Sauvgarder nouvelle email");
	// Optional<Client> personneOptional = PersonneRepository.findByEmail(email);
	// return personneOptional.isPresent(); // Renvoie vrai si l'email existe déjà,
	// faux sinon
	// }

	@Override
	public boolean checkIfEmailExists(String email) {
		Optional<Client> client = personneRepository.findByEmail(email);
		return client.isPresent();
	}

}
