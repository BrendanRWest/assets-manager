package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        Asset home = new House("Home", "August 2021", BigDecimal.valueOf(500000),
                "1007 Ericsson Dr", 1, 5000, 10000);

        Asset beachHouse = new House("Vacation home", "June 2023", BigDecimal.valueOf(400000),
                "315 Waterview Dr", 2, 3500, 7000);

        Asset honda = new Vehicle("Daily driver", "February 2020",
                BigDecimal.valueOf(40000), "Honda Civic", 2020, 112000);

        Asset lambo = new Vehicle("The Womanizer", "July 2024",
                BigDecimal.valueOf(480000), "Lamborghini Aventador", 2024, 13500);

        assets.add(home);
        assets.add(beachHouse);
        assets.add(honda);
        assets.add(lambo);

        for (Asset asset : assets) {
            if(asset instanceof House){
                System.out.println("Address: " + ((House) asset).getAddress() + "\n");
            }
            if(asset instanceof Vehicle){
                System.out.println("Make/Model: " + ((Vehicle) asset).getMakeModel() + "\n");
                System.out.println("Year: " + ((Vehicle) asset).getYear() + "\n");
            }
            System.out.println("Description: " + asset.getDescription() + "\n");
            System.out.println("Date acquired: " + asset.getDateAcquired() + "\n");
            System.out.println("Original cost: $" + asset.getOriginalCost() + "\n");
            System.out.println("Current value: $" + asset.getValue() + "\n");
        }
    }
}
