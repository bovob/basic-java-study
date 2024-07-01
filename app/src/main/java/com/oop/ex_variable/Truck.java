package com.oop.ex_variable;

public class Truck extends Car{
    float ton;
    boolean dump;

    public Truck() {}

    public Truck(String model, int capacity, int cc, int valve, float ton, boolean dump) {
        super(model, capacity, cc, valve);
        this.ton = ton;
        this.dump = dump;
    }
}
