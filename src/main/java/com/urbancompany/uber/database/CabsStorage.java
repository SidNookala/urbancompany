package com.urbancompany.uber.database;

import com.urbancompany.uber.models.Cab;

import java.util.HashMap;
import java.util.HashSet;

public class CabsStorage {

    private static HashMap<String,Cab> cabs = new HashMap<>();

    public static HashMap<String,Cab> getAllCabs(){
        return cabs;
    }

    public static void addCab(Cab cab){
        cabs.put(cab.getId(),cab);
    }

}
