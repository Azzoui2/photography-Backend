package pho.ma.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pho.ma.entities.Client;
import pho.ma.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

    List<Client> findByNomContains(String nom);

    Optional<Client> findByEmail(String email);
}
