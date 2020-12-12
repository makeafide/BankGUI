/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author William Smith
 */
public class Checking extends Account implements Serializable {
    //Class Vars
    int numOfTransactions;
    double overdraftFee;
    ArrayList<Transactions> transactions = new ArrayList<Transactions>();
    //Constructors
    public Checking(){}
    public Checking(double overdraftFee, int accontID, double balance){
       // System.out.println("checking Vars");
        this.overdraftFee = overdraftFee;
        this.setAccountNum(accontID);
        this.setBalance(balance);
        this.numOfTransactions = 0;
    }
    public Checking(Checking checkingInfo){
       // System.out.println("checking object");
        this.overdraftFee = checkingInfo.getOverdraftFee();
    }
    
    //Setters and Getters
    public void setNumOfTransactions(int numOfTransactions){
        this.numOfTransactions = numOfTransactions;
    }
    public int getNumOfTransactions(){
        return(this.numOfTransactions);
    }
    
    public void setOverdraftFee(int overdraftFee){
        this.overdraftFee = overdraftFee;
    }
    public double getOverdraftFee(){
        return(this.overdraftFee);
    }
    
}
