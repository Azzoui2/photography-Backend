package pho.ma.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
}
