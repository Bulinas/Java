package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Resident r0 = new Resident("R0");
        Resident r1 = new Resident("R1");
        Resident r2 = new Resident("R2");
        Resident r3 = new Resident("R3");
        Hospital h0 = new Hospital("H0", 1);
        Hospital h1 = new Hospital("H1", 2);
        Hospital h2 = new Hospital("H2", 2);
        r0.addHospitalPreference(h0);
        r0.addHospitalPreference(h1);
        r0.addHospitalPreference(h2);
        r1.addHospitalPreference(h0);
        r1.addHospitalPreference(h1);
        r1.addHospitalPreference(h2);
        r2.addHospitalPreference(h0);
        r2.addHospitalPreference(h1);
        r3.addHospitalPreference(h0);
        r3.addHospitalPreference(h2);
        h0.addResidentPreference(r3);
        h0.addResidentPreference(r0);
        h0.addResidentPreference(r1);
        h0.addResidentPreference(r2);
        h1.addResidentPreference(r0);
        h1.addResidentPreference(r2);
        h1.addResidentPreference(r1);
        h2.addResidentPreference(r0);
        h2.addResidentPreference(r1);
        h2.addResidentPreference(r3);
        ArrayList<Resident> residents = new ArrayList<Resident>(Arrays.asList(r1, r0, r3, r2));
        System.out.println("Residents before sort:");
        for (Resident resident : residents) {
            System.out.println(resident.getName());
        }
        residents.sort(new ResidentNameComparator());
        System.out.println("Residents after sort:");
        for (Resident resident : residents) {
            System.out.println(resident.getName());
        }
        TreeSet<Hospital> hospitals = new TreeSet<Hospital>(Arrays.asList(h2, h0, h1));
        System.out.println("Hospitals:");
        for (Hospital hospital : hospitals) {
            System.out.println(hospital.getName());
        }
        HashMap<Resident, LinkedHashSet<Hospital>> map1 = new HashMap<Resident, LinkedHashSet<Hospital>>();
        map1.put(r0, r0.getHospitalPreferences());
        map1.put(r1, r1.getHospitalPreferences());
        map1.put(r2, r2.getHospitalPreferences());
        map1.put(r3, r3.getHospitalPreferences());
        for (HashMap.Entry<Resident, LinkedHashSet<Hospital>> entry : map1.entrySet()) {
            System.out.print(entry.getKey().getName() + ":{");
            for (Hospital hospital : entry.getValue()) {
                System.out.print(hospital.getName() + ",");
            }
            System.out.print("}\n");
        }
        LinkedHashMap<Hospital, LinkedHashSet<Resident>> map2 = new LinkedHashMap<Hospital, LinkedHashSet<Resident>>();
        map2.put(h0, h0.getResidentPreferences());
        map2.put(h1, h1.getResidentPreferences());
        map2.put(h2, h2.getResidentPreferences());
        for (Map.Entry<Hospital, LinkedHashSet<Resident>> entry : map2.entrySet()) {
            System.out.print(entry.getKey().getName() + ":{");
            for (Resident resident : entry.getValue()) {
                System.out.print(resident.getName() + ",");
            }
            System.out.print("}\n");
        }
        List<Resident> residents1 = residents.stream().filter(resident -> resident.findHospital(h0) && resident.findHospital(h2)).collect(Collectors.toList());
        System.out.println("Residents with hospital H0 and H2 as preferences:");
        for (Resident resident : residents1) {
            System.out.println(resident.getName());
        }
        List<Hospital> hospitals1 = hospitals.stream().filter(hospital -> hospital.findResidentAsTopPref(r0)).collect(Collectors.toList());
        System.out.println("Hospital with resident R0 as top preference:");
        for (Hospital hospital : hospitals1) {
            System.out.println(hospital.getName());
        }
    }
}
