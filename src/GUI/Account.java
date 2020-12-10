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
public class Account {
    //Class Vars
    private int accountNum,numOfAccounts;
    private double balance, endOfMonthBalance;
  
    
    //Constructors 
    public Account (){}
    public Account (int accountNum, int numOfAccounts, double balance){
     this.accountNum = accountNum;
     this.numOfAccounts = numOfAccounts;
     this.balance = balance;
    }
    public Account (int accountNum, int numOfAccounts, double balance, double endOfMonthBalance){
        this.accountNum = accountNum;
        this.numOfAccounts = numOfAccounts;
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
    
    public void setNumOfAccounts(int numOfAccounts){
       this.numOfAccounts = numOfAccounts;
    }
    public int getNumOfAccounts(){
        return(this.numOfAccounts);
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
