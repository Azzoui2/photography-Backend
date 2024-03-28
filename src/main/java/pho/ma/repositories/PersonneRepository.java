package pho.ma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pho.ma.entities.Personne;
import pho.ma.entities.Reservation;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
