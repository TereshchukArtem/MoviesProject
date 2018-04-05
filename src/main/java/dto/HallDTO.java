package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Entity;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class HallDTO extends Entity<Integer> {
    private String name;
    private String planUrl;
    private int row;
    private int seat;

    public HallDTO(String name, String planUrl, int row, int seat) {
        this.name = name;
        this.planUrl = planUrl;
        this.row = row;
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HallDTO hallDTO = (HallDTO) o;
        return row == hallDTO.row &&
                seat == hallDTO.seat &&
                Objects.equals(name, hallDTO.name) &&
                Objects.equals(planUrl, hallDTO.planUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, planUrl, row, seat);
    }

    @Override
    public String toString() {
        return "HallDTO{" +
                "name='" + name + '\'' +
                ", planUrl='" + planUrl + '\'' +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }
}
