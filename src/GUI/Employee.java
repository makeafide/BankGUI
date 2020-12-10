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
 * @author makeafide
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
    public String getEmployeename(){
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
    public boolean login(int employeeID,int pin){
       for (Employee employee : employees) {
       if(employee.getEmployeeID() == employeeID && employee.getPin() == pin){
        return(true);
       }
       } 
        return(false);
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
                ArrayList<Employee> people2 = (ArrayList<Employee>) readStream.readObject();
                readStream.close();
                employees = people2;
             }
             catch (FileNotFoundException esx) {}
             catch (Exception e) {
                 e.printStackTrace();
              }
     }
    
}
