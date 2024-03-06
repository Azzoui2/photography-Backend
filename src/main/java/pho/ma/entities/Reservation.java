package pho.ma.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Client client;

    @ManyToOne
    private Photographe photographe;

    private boolean finie;
    
    private Status status;
public enum Status {
    EN_ATTENTE,
    CONFIRMEE,
    ANNULEE
}

}



	
