/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author makeafide
 */
public abstract class Customer {
    //Class Vars
     String customerName;
     int customerID;
     int numOfCustomers; 
     
    //Constrctors for the class
    public Customer(){}
    public Customer(String customerName, int customerID, int numOfCustomers){
     this.customerName = customerName;
     this.customerID = customerID;
     this.numOfCustomers = numOfCustomers;         
    }
    
    //Setters and Getters
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public String getCustomerName(){
        return(this.customerName);
    }
    
    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }
    public int getCustomerID(){
        return(this.customerID);
    }
    
    public void setNumOfCustomers(int numOfCustomers){
        this.numOfCustomers = numOfCustomers;
    }
    public int getNumOfCustomers(){
        return(this.numOfCustomers);
    }
    
    
}
