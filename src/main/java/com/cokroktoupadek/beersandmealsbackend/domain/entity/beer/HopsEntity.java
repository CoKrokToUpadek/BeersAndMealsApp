package com.cokroktoupadek.beersandmealsbackend.domain.entity.beer;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "hops")
public class HopsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="hop_id")
    private Long id;

    @NonNull
    @Column(name="hop_name")
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)//bidirectional
    @JoinColumn(name = "hop_amount", referencedColumnName = "amount_value_id")
    private AmountEntity amount;

    @NonNull
    @Column(name="hop_add")
    private String add;

    @NonNull
    @Column(name="hop_attribute")
    private String attribute;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HopsEntity that = (HopsEntity) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!add.equals(that.add)) return false;
        return attribute.equals(that.attribute);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + add.hashCode();
        result = 31 * result + attribute.hashCode();
        return result;
    }
}
