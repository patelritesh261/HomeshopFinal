/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_1;

/**
 *
 * @author ritesh
 */
public class ServiceClass {
    private static int empId=10000;
    private static int pdId=2000;
    //static methods
    public static int getempId()
    {
        return empId++;
    }
     public static int getpdId()
    {
        return pdId++;
    }
    
}
