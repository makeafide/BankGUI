/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.Serializable;

/**
 *
 * @author William Smith
 */
public class Transactions implements Serializable{
    //Class Vars
    String action;
    Double value;
    
    //Constructors
    public Transactions(){}
    public Transactions(String action, Double value){
    
        this.action = action;
        this.value = value;
    
    }
    
    //Setter and Getters
    public void setAction(String action){
        this.action = action;
    }
    public String getAction(){
        return(this.action);
    }
    public void setValue(Double value){
        this.value = value;
    }
    public Double getValue(){
        return(this.value);
    }
    
}
