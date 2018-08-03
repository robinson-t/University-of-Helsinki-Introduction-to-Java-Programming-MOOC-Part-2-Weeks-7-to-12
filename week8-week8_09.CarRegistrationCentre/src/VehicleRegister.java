/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomro
 */
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class VehicleRegister {
    private Map<RegistrationPlate, String> owners;

    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate , String>();
    }
    
    public boolean add(RegistrationPlate plate , String owner) {
        for (RegistrationPlate p : owners.keySet()) {
            if (p.equals(plate)) {
                return false;
            }
        }
        this.owners.put(plate, owner);
        return true;
    }
    
    public String get(RegistrationPlate plate) {
        for (RegistrationPlate p : this.owners.keySet()) {
            if (p.equals(plate)) {
                return owners.get(p);
            }
        }
        return null;
    }
    
    public boolean delete(RegistrationPlate plate) {
        for (RegistrationPlate p : owners.keySet()) {
            if (p.equals(plate)) {
                this.owners.remove(p);
                return true;
            }
        }
        return false;
    }
    
    public void printRegistrationPlates()
    {
        for (RegistrationPlate p : owners.keySet()) {
            System.out.println(p.toString());
        }
        
    }   
    
    public void printOwners() {
        ArrayList<String> names = new ArrayList<String>();
        int isin = 0;
        for (RegistrationPlate p : this.owners.keySet()) {
            for (String s : names) {
                if (this.owners.get(p).equals(s)) {
                    isin = 1;
                }
            }
            if (isin == 0) {
                names.add(this.owners.get(p));
            }
            isin = 0;
        }
        
        for (String s : names) {
            System.out.println(s);
        }
    }
    
}
