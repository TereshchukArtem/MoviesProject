package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends Entity<Integer> {
    private Session session;
    private int row;
    private int seat;
    private int userId;

}
