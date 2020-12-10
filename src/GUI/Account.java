/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author makeafide
 */
public class Account extends Customer {
    //Class Vars
    int accountNum,numOfAccounts;
    double balance, endOfMonthBalance;
    Customer customerInfo;
    //Constructors 
    public Account (){}
    public Account (int accountNum, int numOfAccounts, double balance, Customer customerInfo){
    this.accountNum = accountNum;
    this.numOfAccounts = numOfAccounts;
    this.balance = balance;
    this.customerInfo = customerInfo;
    }
    public Account (int accountNum, int numOfAccounts, double balance, double endOfMonthBalance, Customer customerInfo){
    this.accountNum = accountNum;
    this.numOfAccounts = numOfAccounts;
    this.balance = balance;
    this.endOfMonthBalance = endOfMonthBalance;
    this.customerInfo = customerInfo;
    }
    
    // Setters and Getters
     public void setAccountNum(int accountNum){
       this.accountNum = accountNum;
    }
    public int getNumOfTransactions(){
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
    
    public void setEndOfMonthBalance(Customer customerInfo){
       this.customerInfo = customerInfo;
    }
    public Customer getCustomerInfo(){
        return(this.customerInfo);
    }
       
    
}
