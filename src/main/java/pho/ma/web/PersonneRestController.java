package pho.ma.web;

  
import java.util.List;
 import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;
import pho.ma.entities.Specialites;
import pho.ma.services.PersService;
import pho.ma.services.PersonneService;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*") // // Autorise toutes les origines
public class PersonneRestController {
    private PersService persService;

	 @GetMapping("/personnes")
	    public List<Personne> personnes(){
	        return persService.listClient();
	    }
	 
	 @GetMapping("/reservation")
	    public List<Reservation> reservations(){
	        return persService.ListReservation();
	    }
	 @GetMapping("/specialites")
	    public List<Specialites> specialites(){
	        return persService.ListSpecialites();
	    }
	 
	 
}
