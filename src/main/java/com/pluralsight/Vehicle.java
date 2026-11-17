package com.pluralsight;

import java.math.BigDecimal;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        if (year <= 2026){
            this.year = year;
        } else {
            System.out.println("What, are you from the future or something?");
        }
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int yearDifference = 2026 - year;
        BigDecimal value = originalCost;

        if(yearDifference <= 3) {
            value = value.subtract(value.multiply(BigDecimal.valueOf(.03 * yearDifference)));
        } else if (yearDifference >= 4 && yearDifference <= 6) {
            value = value.subtract(value.multiply(BigDecimal.valueOf(.06 * yearDifference)));
        } else if (yearDifference >= 7 && yearDifference <= 10){
            value = value.subtract(value.multiply(BigDecimal.valueOf(.08 * yearDifference)));
        } else {
            value = BigDecimal.valueOf(1000);
        }

        if(odometer > 100000 && !makeModel.contains("Honda") && !makeModel.contains("Toyota")){
            value = value.subtract(value.multiply(BigDecimal.valueOf(.25)));
        }
        return value;
    }
}
