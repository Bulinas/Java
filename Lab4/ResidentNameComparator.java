package com.company;

import java.util.Comparator;

public class ResidentNameComparator implements Comparator<Resident> {
    @Override
    public int compare(Resident r1, Resident r2){
        return r1.getName().compareTo(r2.getName());
    }
}
