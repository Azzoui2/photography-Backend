package pho.ma.repositories;

 
import org.springframework.data.jpa.repository.JpaRepository;

import pho.ma.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne,String>  {

}
