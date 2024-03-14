package pho.ma.web;

  
import java.util.List;
 import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pho.ma.entities.Personne;
import pho.ma.services.PersService;
import pho.ma.services.PersonneService;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class PersonneRestController {
    private PersService persService;

	 @GetMapping("/personnes")
	    public List<Personne> personnes(){
	        return persService.listPersonnes();
	    }
}
