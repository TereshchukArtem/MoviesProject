package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Entity;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO extends Entity<Integer> {
    private Time deliveryTime;
    private int price;
    private MovieDTO movie;
    private HallDTO hall;

}
