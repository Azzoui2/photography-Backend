package pho.ma.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pho.ma.entities.Client;
import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;
import pho.ma.entities.Specialites;
import pho.ma.repositories.PersonneRepository;
import pho.ma.services.PersService;
import pho.ma.services.PersonneService;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
// @CrossOrigin("*") // // Autorise toutes les origines
public class PersonneRestController {
	private PersonneRepository personneRepository;
	private PersService persService;

	@GetMapping("/personnes")
	public List<Personne> personnes() {
		return persService.listClient();
	}

	@GetMapping("/reservation")
	public List<Reservation> reservations() {
		return persService.ListReservation();
	}

	@GetMapping("/specialites")
	public List<Specialites> specialites() {
		return persService.ListSpecialites();
	}

	@PostMapping("/personnes")
	public Personne saveClient(@RequestBody Client client) {
		// Assurez-vous que les méthodes de service appropriées sont appelées pour
		// traiter le client
		System.out.println("final");
		return persService.saveClient(client);
	}

	@PostMapping("/reservation")
	public Reservation saveReservation(@RequestBody Reservation reservation) {
		// Assurez-vous que les méthodes de service appropriées sont appelées pour
		// traiter le client
		System.out.println("final");
		return persService.saveReservation(reservation);
	}

	@DeleteMapping("/reservation/{id}")
	public void deleteReservation(@PathVariable Long id) {
		persService.deleteReservation(id);
	}

}
