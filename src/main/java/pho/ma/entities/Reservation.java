package pho.ma.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "personne_id")
    @JsonBackReference // Côté enfant de la relation
    private Personne personne;
    
    @JsonBackReference
    @ManyToOne
    private Client client ;
    @JsonBackReference
    @ManyToOne
    private Photographe photographe   ;
    @JsonBackReference
    @ManyToOne
    private Admin admin   ;

    private boolean finie;
    
    @Enumerated(EnumType.STRING)
    private Status type; 
  

    public enum Status {
        EN_ATTENTE,
        CONFIRMEE,
        ANNULEE
    }

}



	
