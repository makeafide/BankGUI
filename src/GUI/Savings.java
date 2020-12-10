/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author makeafide
 */
public class Savings extends Account{
   
    int numOfTransaction;
    double interest;
    
    public Savings(){}
    
    public Savings(int numOfTransaction, double interest){
        
        this.numOfTransaction = numOfTransaction;
        this.interest = interest;
    }
}
