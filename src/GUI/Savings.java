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
public class Savings extends Account implements Serializable{
   //Class Vars
    int numOfTransaction;
    double interest;
    Account accountInfo;
    ArrayList<Transactions> transactions = new ArrayList<Transactions>();
    
    //Constructors
    public Savings(){}
    public Savings(Savings savingsInfo){
        this.interest = savingsInfo.getinterest();
        this.accountInfo = savingsInfo.getAccountInfo();
    }
    public Savings(double interest, int accontID, double balance){
   
        this.interest = interest;
        this.setAccountNum(accontID);
        this.setBalance(balance);
    }
    
    //Setters and Getters
    public void setAccountInfo(Account accountInfo){
        this.accountInfo = accountInfo;
    }
    public Account getAccountInfo(){
        return(this.accountInfo);
    }
    
    public void setNumOfTransaction(int numOfTransaction){
        this.numOfTransaction = numOfTransaction;
    }
    public int getNumOfTransaction(){
        return(this.numOfTransaction);
    }
    
    public void setinterest(double interest){
        this.interest = interest;
    }
    public double getinterest(){
        return(this.interest);
    }
    
    
    
    
}
