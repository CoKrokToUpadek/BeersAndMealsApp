package com.cokroktoupadek.beersandmealsbackend.domain.entity.beer;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "malts")
public class MaltEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="malt_id")
    private Long id;

    @NonNull
    @Column(name="malt_name")
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)//bidirectional
    @JoinColumn(name = "malt_amount", referencedColumnName = "amount_value_id")
    private AmountEntity amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaltEntity that = (MaltEntity) o;

        if (!id.equals(that.id)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
