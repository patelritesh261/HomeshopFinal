/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Employee {
    //Declare variables
     private String firstName,lastName,address,status;
     private int empId,age;
     private long phoneNumber;
     private String position;
     private Date dateOfHire;
     private double payRate;
     Scanner get=new Scanner(System.in);
   boolean b=true;
   //constructor
      public Employee(){
         
        }
     public Employee(String firstName, String lastName, int age, 
            String position, Date dateOfHire,String address,long phoneNumber,String status,double payRate)
     {
         empId=ServiceClass.getempId();
         this.firstName=firstName;
         this.lastName=lastName;
         this.age=age;
         this.address=address;
         this.phoneNumber=phoneNumber;
         this.status=status;
         this.position=position;
         this.payRate=payRate;
         this.dateOfHire=dateOfHire;
         //this.empId=ServiceClass.getempId();
     
     }
     
     //Accessor Methods
      public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public Date getDateOfHire() {
        return dateOfHire;
    }

    public double getPayRate() {
        return payRate;
    }
     public abstract double earning();
    
    //Murator Methods

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDateOfHire(Date dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
     
        
    //Display basic employee information
     @Override
    public String toString(){
       
        return "\n EmployeeId:\t\t"+empId+
                "\n First Name:\t\t"+getFirstName()+
                "\n Last Name:\t\t"+getLastName()+
                "\n Age:\t\t\t"+getAge()+
                "\n Position:\t\t"+getPosition()+
                "\n Date of hire:\t\t"+getDateOfHire()+
                "\n Address:\t\t"+getAddress()+
                "\n Phone Number:\t\t"+getPhoneNumber()+
                "\n Status:\t\t"+getStatus()+
                "\n Pay Rate:\t\t"+getPayRate();
    }

   
     

    
    
}
