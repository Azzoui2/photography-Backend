package pho.ma.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ADM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Personne {
    private String role;

    @OneToMany(mappedBy = "admin")
    private List<Reservation> reservation;
   
}
