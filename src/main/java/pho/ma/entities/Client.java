package pho.ma.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("CLI")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Personne {
	
     String telephone;
     Date date_Res;

//    @OneToMany(mappedBy = "client")
//     List<Reservation> reservation;
//   
}
