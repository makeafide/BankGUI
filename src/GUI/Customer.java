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
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author William Smith
 */
public class Customer implements Serializable{
    //Class Vars
     String customerName;
     int customerID;
   //Class ArrayLists for Customers
    ArrayList<Checking> checkingAccounts = new ArrayList<Checking>();
    ArrayList<Savings> savingsAccounts = new ArrayList<Savings>();
    ArrayList<Loan> loanAccounts = new ArrayList<Loan>();
    ArrayList<Customer> customers = new ArrayList<Customer>();
     
    //Constrctors for the class
    public Customer(){}
    public Customer(String customerName, int customerID){
     this.customerName = customerName;
     this.customerID = customerID;     
    }
    public Customer(String customerName, int customerID,Checking checkingaccountInfo){
     this.customerName = customerName;
     this.customerID = customerID;
     this.checkingAccounts.add(checkingaccountInfo);
    }
     public Customer(String customerName, int customerID,Savings savingsAccountInfo){
     this.customerName = customerName;
     this.customerID = customerID;
     this.savingsAccounts.add(savingsAccountInfo);
    }
     public Customer(String customerName, int customerID,Loan loanAccountInfo){
     this.customerName = customerName;
     this.customerID = customerID;
     this.loanAccounts.add(loanAccountInfo);
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
    
    //Checks if a Customer exista and returns True or False 
    public boolean customerExists(int customerID){
         for (Customer customer : this.customers) {
            if (customer.getCustomerID() == customerID){
                 return(true);
            }
         }
        return(false);
    }
    //Finds the index of a customer in the Array list by Custoemr ID
    public int customerExistsIndex(int customerID){
         for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getCustomerID() == customerID){
                 return(i);
            }
         }
        return(-1);
    }
    //Checks if an acoount Exists and returns true or False
    public boolean accountExists(int accountID){
         for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                if(checking.getAccountNum() == accountID)
                {
                     return(true);    
                }  
             }
             for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountNum() == accountID)
                {
                     return(true);    
                }  
             }
             for (Loan loan : customer.loanAccounts) {
                if(loan.getAccountNum() == accountID)
                {
                     return(true);    
                }  
             }
         }
        return(false);
    }
    //Creates a Checking account for a Customer     
    public Boolean createChecking(Customer customerInfo, Checking checkingInfo){
        //System.out.println("Cust::" + customerInfo.getCustomerID());
        //System.out.println("CustAcct::" + checkingInfo.getAccountNum());
        if(!customerExists(customerInfo.getCustomerID())){
            //System.out.println("passed 1");
            if(!accountExists(checkingInfo.getAccountNum())){
                //System.out.println("CustAcct::" + checkingInfo.getAccountNum());
                //System.out.println("CustNAME::" + customerInfo.getCustomerName());
                //System.out.println("CustaCCTovERfee::" + checkingInfo.getOverdraftFee());
                customers.add(new Customer(customerInfo.getCustomerName(), customerInfo.getCustomerID(), new Checking(checkingInfo.getOverdraftFee(), checkingInfo.getAccountNum(), checkingInfo.getBalance())));
                this.saveCustomers();
                return (true);
            }
            else {return(false);}
        }
        else{
            if(!accountExists(checkingInfo.getAccountNum())){
                 //System.out.println("passed 1");
                customers.get(customerExistsIndex(customerInfo.getCustomerID())).checkingAccounts.add(new Checking(checkingInfo.getOverdraftFee(), checkingInfo.getAccountNum(), checkingInfo.getBalance()));
                this.saveCustomers();
                return (true);
            }  
            else
            {
                return (false);
            }
            }   
    }
    
    //Create a Savings Account For a Customer 
    public Boolean createSavings(Customer customerInfo, Savings savingsInfo){
        //System.out.println("Cust::" + customerInfo.getCustomerID());
        //System.out.println("CustAcct::" + checkingInfo.getAccountNum());
        if(!customerExists(customerInfo.getCustomerID())){
            //System.out.println("passed 1");
            if(!accountExists(savingsInfo.getAccountNum())){
                //System.out.println("CustAcct::" + checkingInfo.getAccountNum());
                //System.out.println("CustNAME::" + customerInfo.getCustomerName());
                //System.out.println("CustaCCTovERfee::" + checkingInfo.getOverdraftFee());
                customers.add(new Customer(customerInfo.getCustomerName(), customerInfo.getCustomerID(), new Savings(savingsInfo.getinterest(), savingsInfo.getAccountNum(), savingsInfo.getBalance())));
                this.saveCustomers();
                return (true);
            }
            else {return(false);}
        }
        else{
                 if(!accountExists(savingsInfo.getAccountNum())){
                     //System.out.println("passed 1");
                     customers.get(customerExistsIndex(customerInfo.getCustomerID())).checkingAccounts.add(new Checking(savingsInfo.getinterest(), savingsInfo.getAccountNum(), savingsInfo.getBalance()));
                     this.saveCustomers();
                     return (true);
                }  
                 else
                {
                    return (false);
                }
            }   
    }
    
    
     public Boolean createLoan(Customer customerInfo, Loan loanInfo){
        //System.out.println("Cust::" + customerInfo.getCustomerID());
        //System.out.println("CustAcct::" + checkingInfo.getAccountNum());
        if(!customerExists(customerInfo.getCustomerID())){
            //System.out.println("passed 1");
            if(!accountExists(loanInfo.getAccountNum())){
                //System.out.println("CustAcct::" + checkingInfo.getAccountNum());
                //System.out.println("CustNAME::" + customerInfo.getCustomerName());
                //System.out.println("CustaCCTovERfee::" + checkingInfo.getOverdraftFee());
                customers.add(new Customer(customerInfo.getCustomerName(), customerInfo.getCustomerID(), new Loan(loanInfo.getMinPayment(), loanInfo.getLateFee(), loanInfo.getInterest(), loanInfo.getBalance(), loanInfo.getAccountNum())));
                this.saveCustomers();
                return (true);
            }
            else {return(false);}
        }
        else{
                 if(!accountExists(loanInfo.getAccountNum())){
                     //System.out.println("passed 1");
                     customers.get(customerExistsIndex(customerInfo.getCustomerID())).loanAccounts.add(new Loan(loanInfo.getMinPayment(), loanInfo.getLateFee(), loanInfo.getInterest(), loanInfo.getBalance(), loanInfo.getAccountNum()));
                     this.saveCustomers();
                     return (true);
                }  
                 else
                {
                    return (false);
                }
            }   
    }
    

    //Finds Account by Account Number and returns table to display for Account Details
    public DefaultTableModel accountDetails(int accountID){
        for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                //f System.out.println("Found customer:: " + customer.checkingAccounts.size());
                 if(checking.getAccountNum() == accountID)
                 {
                    
                  DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Account Type");
                  model.addColumn("Customer Name"); 
                  model.addColumn("Customer ID"); 
                  model.addColumn("Account ID"); 
                  model.addColumn("Balance"); 
                  model.addColumn("OverDraft Fee");
                  model.addColumn("Total Transactions");
                  model.addRow(new Object[]{"Checking", customer.getCustomerName(), customer.getCustomerID(), checking.getAccountNum(), checking.getBalance(), checking.getOverdraftFee(), checking.getNumOfTransactions()});
                 return(model);
                 }  
         
            }
       for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountNum() == accountID)
                {
                  DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Account Type"); 
                  model.addColumn("Customer Name"); 
                  model.addColumn("Customer ID"); 
                  model.addColumn("Account ID"); 
                  model.addColumn("Balance"); 
                  model.addColumn("Interest Rate");
                  model.addColumn("Total Transactions");
                  model.addRow(new Object[]{"Savings", customer.getCustomerName(), customer.getCustomerID(), savings.getAccountNum(), savings.getBalance(), savings.getinterest(), savings.getNumOfTransaction()});
                 return(model);      
                }  
             }
              for (Loan loan : customer.loanAccounts) {
                if(loan.getAccountNum() == accountID)
                {
                  DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Account Type"); 
                  model.addColumn("Customer Name"); 
                  model.addColumn("Customer ID"); 
                  model.addColumn("Account ID"); 
                  model.addColumn("Balance"); 
                  model.addColumn("Minmum Payment");
                  model.addColumn("Late Fee");
                  model.addColumn("Interest");
                  model.addColumn("Total Transactions");
                  model.addRow(new Object[]{"Loan", customer.getCustomerName(), customer.getCustomerID(), loan.getAccountNum(), loan.getBalance(), loan.getMinPayment(), loan.getLateFee(), loan.getInterest(), loan.getNumOfTransaction()});
                 return(model);      
                }  
             }
        }
        return (new DefaultTableModel());
    }
    
    //Lists a accounts then returns a table results.
    public DefaultTableModel listAllAccounts(){
        DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Account ID"); 
                  model.addColumn("Account Type");
                  model.addColumn("Customer Name"); 
                  model.addColumn("Customer ID"); 
                  model.addColumn("Balance"); 
        for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                  model.addRow(new Object[]{checking.getAccountNum(), "Checking", customer.getCustomerName(), customer.getCustomerID(), checking.getBalance()});
                 
                 }  
         
            
       for (Savings savings : customer.savingsAccounts) {
                  model.addRow(new Object[]{savings.getAccountNum(), "Savings", customer.getCustomerName(), customer.getCustomerID(), savings.getBalance()});
                 
                  }  
       for (Loan loan : customer.loanAccounts) {
                  model.addRow(new Object[]{loan.getAccountNum(), "Loan", customer.getCustomerName(), customer.getCustomerID(), loan.getBalance()});
                 
                  } 
             }
        return(model);
    }
        
        // Finds all customer and returns a Table with the results.     
        public DefaultTableModel listAllCustomers(){
        DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Customer Name"); 
                  model.addColumn("Customer ID"); 
        for (Customer customer : this.customers) {
                  model.addRow(new Object[]{ customer.getCustomerName(), customer.getCustomerID()});
}
        return(model);
    }
    
        public boolean removeAccount(int accountID){
         for (Customer customer : this.customers) {
             for (int i = 0; i < customer.checkingAccounts.size(); i++) {
                  if(customer.checkingAccounts.get(i).getAccountNum() == accountID){
                {
                    customer.checkingAccounts.remove(i);
                    return(true);    
                }  
             }
               for (int k = 0; k < customer.savingsAccounts.size(); k++) {
                  if(customer.savingsAccounts.get(k).getAccountNum() == accountID){
                
                    customer.savingsAccounts.remove(k);
                    return(true);    
                }  
             }
             for (int k = 0; k < customer.loanAccounts.size(); k++) {
                  if(customer.loanAccounts.get(k).getAccountNum() == accountID){
                
                    customer.loanAccounts.remove(k);
                    return(true);    
                }  
             }
         }
        }
        return(false);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Dumps current customer and Account Data to file
    public void saveCustomers(){
        try{
            FileOutputStream fos = new FileOutputStream("accounts.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(this.customers);
        }
        catch (IOException e){ e.printStackTrace();}
    }
     //Loads current customer and Account Data from File
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
