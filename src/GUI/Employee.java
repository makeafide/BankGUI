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
/**
 *
 * @author William Smith
 */
public class Employee implements Serializable {
    // Class Vars
   private String employeeName;
   private int employeeID, pin;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    
    //Constructors 
    public Employee() {}
    public Employee(String employeeName, int employeeID, int pin){
      this.employeeName = employeeName;
      this.employeeID = employeeID;
      this.pin = pin;
    }
    
    //Setters and Getters
    public void setEmployeeName(String employeeName){
     this.employeeName = employeeName; 
    }
    public String getEmployeeName(){
        return(this.employeeName);
    }
    
    public void setEmployeeID(int employeeID){
     this.employeeID = employeeID; 
    }
    public int getEmployeeID(){
        return(this.employeeID);
    }
    
    public void setPin(int pin){
     this.employeeID = employeeID; 
    }
    public int getPin(){
        return(this.pin);
    }
    // Checks if submitted Info is a Valid Employee and Pin
    public boolean login(int employeeID,int pin){
       for (Employee employee : employees) {
       if(employee.getEmployeeID() == employeeID && employee.getPin() == pin){
        return(true);
       }
       } 
        return(false);
    }
    //Removes Employee from ArrayList
    public boolean removeEmployee(int employeeID){
         for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).employeeID == employeeID){
             employees.remove(i);
             return(true);
            }
         }
        return (false);
    }
    
     
    
        public void saveEmployees() throws IOException{
        try{
            FileOutputStream fos = new FileOutputStream("employees.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(this.employees);
        }
        catch (IOException e){ e.printStackTrace();}
    }
    
     public void loadEmployees() throws IOException, ClassNotFoundException{
         try{
                FileInputStream readData = new FileInputStream("employees.dat");
                ObjectInputStream readStream = new ObjectInputStream(readData);
                ArrayList<Employee> employeeRead = (ArrayList<Employee>) readStream.readObject();
                readStream.close();
                employees = employeeRead;
             }
             catch (FileNotFoundException esx) {}
             catch (Exception e) {
                 e.printStackTrace();
              }
     }
    
}
