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
public class Account implements Serializable {
    //Class Vars
    private int accountNum;
    private double balance, endOfMonthBalance;
  
    
    //Constructors 
    public Account (){}
    public Account (int accountNum, double balance){
     this.accountNum = accountNum;
     this.balance = balance;
    }
    public Account (int accountNum, int numOfAccounts, double balance, double endOfMonthBalance){
        this.accountNum = accountNum;
        this.balance = balance;
        this.endOfMonthBalance = endOfMonthBalance;
    }
    
    // Setters and Getters
     public void setAccountNum(int accountNum){
       this.accountNum = accountNum;
    }
    public int getAccountNum(){
        return(this.accountNum);
    }
    
    public void setBalance(double balance){
       this.balance = balance;
    }
    public double getBalance(){
        return(this.balance);
    }
    
    public void setEndOfMonthBalance(double endOfMonthBalance){
       this.endOfMonthBalance = endOfMonthBalance;
    }
    public double getEndOfMonthBalance(){
        return(this.endOfMonthBalance);
    }
    
}
