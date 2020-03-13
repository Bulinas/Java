package com.company;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Resident {
    private String name;
    private LinkedHashSet<Hospital> hospitalPreferences = new LinkedHashSet<Hospital>();

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LinkedHashSet<Hospital> getHospitalPreferences() {
        return hospitalPreferences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHospitalPreferences(LinkedHashSet<Hospital> hospitalPreferences) {
        this.hospitalPreferences = hospitalPreferences;
    }

    public void addHospitalPreference(Hospital hospital) {
        hospitalPreferences.add(hospital);
    }

    public boolean findHospital(Hospital hospital){
        for (Hospital hospital1: hospitalPreferences){
            if (hospital.getName() == hospital1.getName()){
                return true;
            }
        }
        return false;
    }
}
