package com.cokroktoupadek.beersandmealsbackend.domain.entity.beer;


import lombok.*;


import javax.persistence.*;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "temp_values")
public class TempEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="temp_value_id")
    private Long id;

    @NonNull
    @Column(name="temp_value_value")
    private  Integer value;

    @NonNull
    @Column(name="temp_value_unit")
    private  String unit;

    @OneToMany(mappedBy = "temp")
    private List<MashTempEntity> mashTempList;

    @OneToMany(mappedBy = "temp")
    private List<FermentationEntity> fermentationTempList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TempEntity that = (TempEntity) o;

        if (!id.equals(that.id)) return false;
        if (!value.equals(that.value)) return false;
        return unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }
}
