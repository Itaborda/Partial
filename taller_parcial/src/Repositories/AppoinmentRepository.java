package Repositories;

import entities.Appoinment;

import java.util.ArrayList;

public class AppoinmentRepository {
    ArrayList<Appoinment> listC = new ArrayList<>();

    public void saveAppoinment(Appoinment a) {
        listC.add(a);
    }

    public ArrayList<Appoinment> getAll() {
        return listC;
    }

    public void showAllAppoinment() {
        listC.forEach(System.out::println);
    }

    public Appoinment getBycode(String code) {
        for (Appoinment a : listC) {
            if (a.getCode().equals(code)) {
                return a;
            }
        }
        return null;
    }
}
