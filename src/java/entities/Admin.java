/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author faouzia
 */
@Entity
public class Admin extends User implements Serializable{

    public Admin() {
    }

    public Admin(String email, String password) {
        super(email, password);
    }

    public Admin(String email, String password, int etat, String code) {
        super(email, password, etat, code);
    }
    

}
