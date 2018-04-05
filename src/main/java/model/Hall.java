package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Hall extends Entity<Integer> {
    private String name;
    private String planUrl;
    private int row;
    private int seat;


    public Hall(String name, String planUrl, int row, int seat) {
        this.name = name;
        this.planUrl = planUrl;
        this.row = row;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "name='" + name + '\'' +
                ", planUrl='" + planUrl + '\'' +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hall hall = (Hall) o;
        return row == hall.row &&
                seat == hall.seat &&
                Objects.equals(name, hall.name) &&
                Objects.equals(planUrl, hall.planUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, planUrl, row, seat);
    }
}
