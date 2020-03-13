package com.company;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Hospital implements Comparable<Hospital>{
    private String name;
    private int capacity;
    private LinkedHashSet<Resident> residentPreferences = new LinkedHashSet<Resident>();

    public Hospital(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public LinkedHashSet<Resident> getResidentPreferences() {
        return residentPreferences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setResidentPreferences(LinkedHashSet<Resident> residentPreferences) {
        this.residentPreferences = residentPreferences;
    }

    public void addResidentPreference(Resident resident){
        residentPreferences.add(resident);
    }

    public boolean findResidentAsTopPref(Resident resident){
        if (resident.getName() == residentPreferences.stream().findFirst().get().getName()){
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(Hospital otherHospital){
        return this.name.compareTo(otherHospital.getName());
    }
}
