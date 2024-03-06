package pho.ma.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Photographe extends Personne {
	  @OneToMany(mappedBy = "photographe")
	    private List<Reservation> reservations;
}
