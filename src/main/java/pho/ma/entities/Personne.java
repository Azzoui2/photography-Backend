package pho.ma.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING, length = 20)

@Data @NoArgsConstructor @AllArgsConstructor
public class Personne implements Serializable {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String email;
    private String mot_de_passe;
    private String nom;
    private String prenom;

    @Column(insertable = false, updatable = false) // Ajoutez cette annotation
    private String role;
//    //client
//    @OneToMany(mappedBy = "personne")
//    private List<Reservation> reservations;
//
//    //photographer
//    @ManyToMany
//    private List<Specialites> specialites;
}
