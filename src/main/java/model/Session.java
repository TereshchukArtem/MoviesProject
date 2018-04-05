package model;

import lombok.*;


import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session extends Entity<Integer> {
    private Time deliveryTime;
    private int price;
    private Movie movie;
    private Hall hall;

}
