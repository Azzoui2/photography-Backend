package pho.ma.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pho.ma.entities.Client;
import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;
import pho.ma.entities.Specialites;
import pho.ma.repositories.PersonneRepository;
import pho.ma.services.PersService;
import pho.ma.services.PersServiceImp;
import pho.ma.services.PersonneService;

@RestController
@AllArgsConstructor
@Slf4j
// @CrossOrigin(origins = "http://localhost:4200")

@CrossOrigin("*") // // Autorise toutes les origines
public class PersonneRestController {
	private PersonneRepository personneRepository;
	private PersService persService;

	@GetMapping("/personnes")
	public List<Personne> personnes() {
		return persService.listClient();
	}

	@GetMapping("/personnes/recherch")
	public List<Client> personnesRecherch(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
		return persService.personnesRecherch(keyword);
	}

	@GetMapping("/reservation")
	public List<Reservation> reservations() {
		System.out.println("333333333333333333");
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
		System.out.println("final");
		return persService.saveReservation(reservation);
	}

	@DeleteMapping("/reservation/{id}")
	public void deleteReservation(@PathVariable Long id) {
		persService.deleteReservation(id);
	}

	@PutMapping("reservation/{id}")
	public ResponseEntity<?> confirmReservation(@PathVariable("id") Long id) {

		Reservation reservation = persService.findById(id);
		if (reservation == null) {
			return ResponseEntity.notFound().build();
		}
		reservation.setType(Reservation.Status.CONFIRMEE);
		persService.saveReservation(reservation);
		return ResponseEntity.ok().build();

	}

	// Endpoint pour vérifier si l'email existe déjà

	@GetMapping("personnes/check-email/{email}")
	public ResponseEntity<Boolean> checkIfEmailExists(@PathVariable String email) {
		boolean exists = persService.checkIfEmailExists(email);
		System.out.println(exists);
		return ResponseEntity.ok(exists);
	}
}