package Repositories;

import entities.Benefit;

import java.util.ArrayList;

public class BenefitRepository {
    ArrayList<Benefit> listB = new ArrayList<>();

    public void saveBenefit(Benefit b){
        listB.add(b);
    }

    public ArrayList<Benefit> getAll(){
        return listB;
    }

    public void showAllBenefit(){
        listB.forEach(System.out::println);
    }

    public Benefit getByCode(String code){
        for(Benefit b: listB){
            if(b.getCode().equals(code)){
                return b;
            }
        }
        return null;
    }
}
