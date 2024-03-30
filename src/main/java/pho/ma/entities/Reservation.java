package pho.ma.entities;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
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
    private String date;
    private String heure;
    private String adresse;
    private String type_photo;
    @ManyToOne
    @JoinColumn(name = "personne_id")
    @JsonIgnore
    private Personne personne;

    // @JsonIgnore
    // @ManyToOne
    // private Client client;

    @JsonIgnore
    @ManyToOne
    private Photographe photographe;

    @JsonIgnore
    @ManyToOne
    private Admin admin;

    private boolean finie;

    @Enumerated(EnumType.STRING)
    private Status type;

    public enum Status {
        EN_ATTENTE,
        CONFIRMEE,
        ANNULEE
    }
}
