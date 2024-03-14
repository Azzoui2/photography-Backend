package pho.ma.services;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;
 import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;
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
	
	private SpecialitesRepository specialitesRepository ;
	
//	Logger log= LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public Personne savePersonne(Personne personne) {
		log.info("Sauvgarder nouvelle clinet");
		Personne savePersonne = personneRepository.save(personne);
		
		return savePersonne;
	}


	 
	@Override
	public List<Personne> listPersonnes() {
		// TODO Auto-generated method stub
		return personneRepository.findAll();
	}

	@Override
	public Reservation savareservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation getReservation() {
		// TODO Auto-generated method stub
		return null;
	}

}
