/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author makeafide
 */
public class Customer {
    //Class Vars
     String customerName;
     int customerID;
     int numOfCustomers; 
    ArrayList<Checking> checkingAccounts = new ArrayList<Checking>();
    ArrayList<Savings> savingsAccounts = new ArrayList<Savings>();
    ArrayList<Loan> loanAccounts = new ArrayList<Loan>();
    ArrayList<Customer> customers = new ArrayList<Customer>();
     
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
        public boolean customerExists(int customerID){
         for (Customer customer : this.customers) {
            if (customer.getCustomerID() == customerID){
                 return(true);
            }
         }
        return(false);
    }
    public boolean accountExists(int accountID){
         for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                if(checking.getAccountInfo().getAccountNum() == accountID)
                {
                     return(true);    
                }  
             }
             for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountInfo().getAccountNum() == accountID)
                {
                     return(true);    
                }  
             }
         }
        return(false);
    }
         
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void saveCustomers() throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream("accounts.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(this.customers);
        }
        catch (IOException e){ e.printStackTrace();}
    }
    
     public void loadCustomers() throws IOException, ClassNotFoundException{
         try{
                FileInputStream readData = new FileInputStream("accounts.dat");
                ObjectInputStream readStream = new ObjectInputStream(readData);
                ArrayList<Customer> read = (ArrayList<Customer>) readStream.readObject();
                readStream.close();
                customers = read;
             }
             catch (FileNotFoundException esx) {}
             catch (Exception e) {
                 e.printStackTrace();
              }
     }
    
}
