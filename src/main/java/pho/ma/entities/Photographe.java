package pho.ma.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("PHO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photographe extends Personne {

    private String adresse;
    private Boolean disponibilite;
    private Date date_Embauche;

    @OneToMany(mappedBy = "photographe")
    private List<Reservation> reservations;

    @ManyToMany
    private List<Specialites> specialites;
}
