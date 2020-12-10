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
public class Savings extends Account{
   
    int numOfTransaction;
    double interest;
    Account accountInfo;
    
    public Savings(){}
    
    public Savings(int numOfTransaction, double interest){
        
        this.numOfTransaction = numOfTransaction;
        this.interest = interest;
    }
    public Savings(int numOfTransaction, double interest, Account accountInfo){
        
        this.numOfTransaction = numOfTransaction;
        this.interest = interest;
        this.accountInfo = accountInfo;
    }
    
    public void setAccountInfo(Account accountInfo){
        this.accountInfo = accountInfo;
    }
    public Account getAccountInfo(){
        return(this.accountInfo);
    }
}
