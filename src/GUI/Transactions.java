/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author makeafide
 */
public class Transactions {
    //Class Vars
    int account;
    String action;
    Double value;
    
    //Constructors
    public Transactions(){}
    public Transactions(int account, String action, Double value){
    
        this.account = account;
        this.action = action;
        this.value = value;
    
    }
    
    //Setter and Getters
    
    public void setAccount(int account){
        this.account = account;
    }
    public int getAccount(){
        return(this.account);
    }
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
