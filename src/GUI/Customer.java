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
    
   //Attemps to deposit ammount in Either a Checking or Savings Account
    public boolean makeDeposit(int accountID, Double amount){
         for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                if(checking.getAccountNum() == accountID)
                {
                     checking.setBalance(checking.getBalance() + amount);
                     checking.transactions.add(new Transactions("Deposit", amount));
                     this.saveCustomers();
                     return(true);    
                }  
             }
             for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountNum() == accountID)
                {
                     savings.setBalance(savings.getBalance() + amount);
                     savings.transactions.add(new Transactions("Deposit", amount));
                     this.saveCustomers();
                     return(true);    
                }  
             }
             for (Loan loan : customer.loanAccounts) {
                if(loan.getAccountNum() == accountID)
                {
                     return(false);    
                }  
             }
         }
        return(false);
    }
    
    //Attemps to make a Payment on a Loan Account
    public boolean makePayment(int accountID, Double amount){
         for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                if(checking.getAccountNum() == accountID)
                { 
                    return(false);
                }  
             }
             for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountNum() == accountID)
                {
                  return(false); 
                }  
             }
             for (Loan loan : customer.loanAccounts) {
                if(loan.getAccountNum() == accountID)
                {
                    if(amount >= loan.getMinPayment()){ 
                    loan.setBalance(loan.getBalance() - amount);
                    loan.transactions.add(new Transactions("Loan Payment", amount));
                    this.saveCustomers();
                     return(true);  
                    }
                    else
                    {
                      return(false);
                    }
                }  
             }
         }
        return(false);
    }
    
        //Attemps to Widthdraw ammount in Either a Checking or Savings Account
    public boolean makeWidthdraw(int accountID, Double amount){
         for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                if(checking.getAccountNum() == accountID)
                { 
                     Double currAmount = 0.00;
                     currAmount = checking.getBalance() - amount;
                     if (currAmount < 0.00)
                     {
                     checking.setBalance(currAmount - checking.getOverdraftFee());
                     checking.transactions.add(new Transactions("Widthdraw", amount*-1));
                     checking.transactions.add(new Transactions("Overdraft Fee", checking.getOverdraftFee()*-1));
                     this.saveCustomers();
                     return(true); 
                     }
                     else
                     {
                     checking.setBalance(currAmount);
                     checking.transactions.add(new Transactions("Widthdraw", amount*-1));
                     this.saveCustomers();
                      return(true);
                     }
                }  
             }
             for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountNum() == accountID)
                {
                     Double currAmount = 0.00;
                     currAmount = savings.getBalance() - amount;
                     if (currAmount < 0)
                     {
                     return(false); 
                     }
                     else
                     {
                      savings.setBalance(currAmount);
                      savings.transactions.add(new Transactions("Widthdraw", amount*-1));
                      this.saveCustomers();
                      return(true);
                     }   
                }  
             }
             for (Loan loan : customer.loanAccounts) {
                if(loan.getAccountNum() == accountID)
                {
                     return(false);    
                }  
             }
         }
        return(false);
    }
    
        //Attemps to Transfer Funds from one account to another
        public boolean makeTransfer(int toAccountID, int fromAccountID, Double amount){
         for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                if(checking.getAccountNum() == fromAccountID)
                { 
                     Double currAmount = 0.00;
                     currAmount = checking.getBalance() - amount;
                     if (currAmount < 0.00)
                     {
                     return(false); 
                     }
                     else
                     {
                     checking.setBalance(currAmount);
                     checking.transactions.add(new Transactions("Transfer -> TO -> "+ toAccountID, amount*-1));
                     this.saveCustomers();
                     }
                }  
             }
             for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountNum() == fromAccountID)
                {
                     Double currAmount = 0.00;
                     currAmount = savings.getBalance() - amount;
                     if (currAmount < 0)
                     {
                     return(false); 
                     }
                     else
                     {
                      savings.setBalance(currAmount);
                      savings.transactions.add(new Transactions("Transfer -> TO -> "+ toAccountID, amount*-1));
                      this.saveCustomers();
                     }   
                }  
             }
             for (Loan loan : customer.loanAccounts) {
                if(loan.getAccountNum() == fromAccountID)
                {
                     return(false);    
                }  
             }

             for (Checking checkingTo : customer.checkingAccounts) {
                if(checkingTo.getAccountNum() == toAccountID)
                {
                     checkingTo.setBalance(checkingTo.getBalance() + amount);
                     checkingTo.transactions.add(new Transactions("Transfer -> From -> "+ fromAccountID, amount));
                     this.saveCustomers();
                     return(true);    
                }  
             }
             for (Savings savingsTo : customer.savingsAccounts) {
                if(savingsTo.getAccountNum() == toAccountID)
                {
                     savingsTo.setBalance(savingsTo.getBalance() + amount);
                     savingsTo.transactions.add(new Transactions("Transfer -> From -> "+ fromAccountID, amount));
                     this.saveCustomers();
                     return(true);    
                }  
             }
             for (Loan loanTo : customer.loanAccounts) {
                if(loanTo.getAccountNum() == toAccountID)
                {
                     this.makeDeposit(fromAccountID,amount);
                     return(false);    
                }  
             }
         
         }
        this.makeDeposit(fromAccountID,amount);
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
                     customers.get(customerExistsIndex(customerInfo.getCustomerID())).savingsAccounts.add(new Savings(savingsInfo.getinterest(), savingsInfo.getAccountNum(), savingsInfo.getBalance()));
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
                // System.out.println("Found customer:: " + customer.checkingAccounts.size());
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
    //List all transaction for an account the retun a table
     public DefaultTableModel accountTrans(int accountID){
        for (Customer customer : this.customers) {
             for (Checking checking : customer.checkingAccounts) {
                // System.out.println("Found customer:: " + customer.checkingAccounts.size());
                 if(checking.getAccountNum() == accountID)
                 {
                    
                  DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Action");
                  model.addColumn("Value"); 
                  for (Transactions transaction : checking.transactions) {
                  model.addRow(new Object[]{transaction.getAction(), transaction.getValue()});
                 }  
                  return(model);
         
            }
             }
       for (Savings savings : customer.savingsAccounts) {
                if(savings.getAccountNum() == accountID)
                {
                  DefaultTableModel model = new DefaultTableModel();
                  model.addColumn("Action");
                  model.addColumn("Value"); 
                  for (Transactions transaction : savings.transactions) {
                  model.addRow(new Object[]{transaction.getAction(), transaction.getValue()});      
                } 
                  return(model);
             }
       }
              for (Loan loan : customer.loanAccounts) {
                if(loan.getAccountNum() == accountID)
                {
                  DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Action");
                  model.addColumn("Value"); 
                  for (Transactions transaction : loan.transactions) {
                  model.addRow(new Object[]{transaction.getAction(), transaction.getValue()});
                       
                }
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
             for (int j = 0; j < customer.loanAccounts.size(); j++) {
                  if(customer.loanAccounts.get(j).getAccountNum() == accountID){
                
                    customer.loanAccounts.remove(j);
                    return(true);    
                }  
             }
         }
        }
        return(false);
    }
    
    //Run End of Month add intrest to Loan Accounts and give interest payments to Savings Accounts
    public DefaultTableModel endOfMonth(){
        for (Customer customer : this.customers) {
            for (int k = 0; k < customer.savingsAccounts.size(); k++) {
                 Double addIntrest = customer.savingsAccounts.get(k).getBalance() * customer.savingsAccounts.get(k).getinterest();
                 customer.savingsAccounts.get(k).setBalance(customer.savingsAccounts.get(k).getBalance() + addIntrest);
             }
             for (int j = 0; j < customer.loanAccounts.size(); j++) {
                Double addIntrest = customer.loanAccounts.get(j).getBalance() * customer.loanAccounts.get(j).getInterest();
                customer.savingsAccounts.get(j).setBalance(customer.savingsAccounts.get(j).getBalance() + addIntrest);  
             }
         }
         DefaultTableModel model = new DefaultTableModel(); 
                  model.addColumn("Account Type");
                  model.addColumn("Total Accounts"); 
                  model.addColumn("Total Balance");
                  double totalBal = 0.00;
                  int totalAccount = 0;
              for (Customer customer : this.customers) {
                for (Checking checking : customer.checkingAccounts) {
                    totalBal = totalBal + checking.getBalance();
                    totalAccount = totalAccount + 1;
                 }  
             }
               model.addRow(new Object[]{"Checking", totalAccount, totalBal});
               totalBal = 0.00;
               totalAccount = 0;
               for (Customer customer : this.customers) {
                for (Savings savings : customer.savingsAccounts) {
                    totalBal = totalBal + savings.getBalance();
                    totalAccount = totalAccount + 1;
                 }  
             }
               model.addRow(new Object[]{"Savings", totalAccount, totalBal});
               totalBal = 0.00;
               totalAccount = 0;
               for (Customer customer : this.customers) {
                 for (Loan loan : customer.loanAccounts) {
                    totalBal = totalBal + loan.getBalance();
                    totalAccount = totalAccount + 1;
                 }  
             }
               model.addRow(new Object[]{"Loan", totalAccount, totalBal});
               return(model);
      
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
