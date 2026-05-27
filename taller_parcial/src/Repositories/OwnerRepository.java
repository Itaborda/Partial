package Repositories;

import entities.Owner;

import java.util.ArrayList;

public class OwnerRepository {
    ArrayList<Owner> list = new ArrayList<>();

    public void saveOwner(Owner o){
        list.add(o);
    }

    public ArrayList<Owner> getAll(){
        return list;
    }

    public void showAllOwner(){
        list.forEach(System.out::println);
    }

    public Owner getById(String id){
        for(Owner o : list) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

}
