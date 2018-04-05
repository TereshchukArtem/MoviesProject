package dto;

import lombok.*;
import model.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO extends Entity<Integer> {
    private SessionDTO session;
    private int row;
    private int seat;
    private int userId;

}
