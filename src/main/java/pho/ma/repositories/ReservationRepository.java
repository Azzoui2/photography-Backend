package pho.ma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pho.ma.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
