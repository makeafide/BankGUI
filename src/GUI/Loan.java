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
public class Loan extends Account implements Serializable {
  
// Class Vars
double minPayment, lateFee, interest;
int numOfTransaction;
ArrayList<Transactions> transactions = new ArrayList<Transactions>();
  //Constructors  
  public Loan(){} 
  public Loan (double minPayment,double lateFee,double interest){
    this.minPayment = minPayment;
    this.lateFee = lateFee;
    this.interest = interest;  
    this.numOfTransaction = 0;
  }
    public Loan (double minPayment,double lateFee,double interest, double balance, int accountID){
    this.minPayment = minPayment;
    this.lateFee = lateFee;
    this.interest = interest; 
    this.setBalance(balance);
    this.setAccountNum(accountID);
     this.numOfTransaction = 0;
  }
  
    //Setters and Getters
     public void setMinPayment(Double minPayment){
        this.minPayment = minPayment;
    }
    public double getMinPayment(){
        return(this.minPayment);
    }
    public void setLateFee(Double lateFee){
        this.lateFee = lateFee;
    }
    public double getLateFee(){
        return(this.lateFee);
    }
    public void setInterest(Double interest){
        this.lateFee = lateFee;
    }
    public double getInterest(){
        return(this.lateFee);
    }
    public void setNumOfTransaction(int numOfTransaction){
        this.numOfTransaction = numOfTransaction;
    }
    public int getNumOfTransaction(){
        return(this.numOfTransaction);
    }
}
