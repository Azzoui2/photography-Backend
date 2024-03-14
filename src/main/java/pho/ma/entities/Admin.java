package pho.ma.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    @OneToMany(mappedBy = "admin")
    private List<Reservation> reservation;
   
}
