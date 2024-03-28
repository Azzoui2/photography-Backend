package pho.ma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Data;
import pho.ma.entities.Client;
import pho.ma.entities.Personne;
import pho.ma.entities.Photographe;
import pho.ma.repositories.PersonneRepository;

@Service
@Transactional
@Data
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    public void consulter() {
        Personne personne = personneRepository.findById(null).orElse(null);
        if (personne != null) {
            System.out.println("*****************************");
            System.out.println(personne.getId());
            System.out.println(personne.getEmail());
            System.out.println(personne.getPrenom());
            System.out.println(personne.getNom());
            // System.out.println(personne.getRole());
            System.out.println(personne.getClass().getSimpleName());
            if (personne instanceof Client) {
                System.out.println("telephone=>" + ((Client) personne).getTelephone());
            } else if (personne instanceof Photographe) {
                System.out.println("adresse=>" + ((Photographe) personne).getAdresse());
            }

        }
    }
}
