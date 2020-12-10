/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author makeafide
 */
public class Checking extends Account {
    //Class Vars
    int numOfTransactions;
    double overdraftFee;
    Account accountInfo;
    //Constructors
    public Checking(){}
    public Checking(int numOfTransactions, double overdraftFee){
        
        this.numOfTransactions = numOfTransactions;
        this.overdraftFee = overdraftFee;
    }
    
    
    //Setters and Getters
    public void setNumOfCustomers(int numOfTransactions){
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
    
    public void setAccountInfo(Account accountInfo){
        this.accountInfo = accountInfo;
    }
    public Account getAccountInfo(){
        return(this.accountInfo);
    }
    
}
