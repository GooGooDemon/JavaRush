package com.javarush.test.level20.lesson02.task01;


public class Asset  {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass())
            return false;

        Asset other = (Asset) obj;

        boolean cmp = name.equals(other.name);
        if (!cmp) {
            return false;
        }

        if (Double.compare(price, other.price) != 0) {
            return false;
        }

        return true;
    }
}
