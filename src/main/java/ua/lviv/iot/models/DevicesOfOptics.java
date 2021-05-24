package ua.lviv.iot.models;

import lombok.*;

import org.springframework.objenesis.instantiator.annotations.Instantiator;
import ua.lviv.iot.enums.Country;
import ua.lviv.iot.enums.DeviceType;
import ua.lviv.iot.enums.Equipment;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "devices")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DevicesOfOptics extends Devices{

    private String lens;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public DevicesOfOptics(float price, String matherial, Country originCountry, Equipment category,
                           int weightInGrams, DeviceType ELECTRICITY_AND_MAGNETISM, String lens, Integer id) {
        super(price, matherial, originCountry, category, weightInGrams, ELECTRICITY_AND_MAGNETISM);
        this.lens = lens;
        this.id = id;
    }
}

