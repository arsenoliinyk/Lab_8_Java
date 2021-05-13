package ua.lviv.iot.models;

import lombok.Data;
import ua.lviv.iot.enums.Country;
import ua.lviv.iot.enums.DeviceType;
import ua.lviv.iot.enums.Equipment;

@Data
public class Devices {
    private float price;
    private String matherial;
    private Country originCountry;
    private Equipment category;
    private int weightInGrams;
    private DeviceType type;


    public Devices() {}


    public Devices(float price, String matherial, Country originCountry, Equipment category, int weightInGrams, DeviceType type) {
        this.price = price;
        this.matherial = matherial;
        this.originCountry = originCountry;
        this.category = category;
        this.weightInGrams = weightInGrams;
        this.type = type;
    }
}
