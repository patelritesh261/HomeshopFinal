/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.*;
import java.util.*;

/**
 *
 * @author ritesh
 */
public class IOTester {
    public static void main (String[] args0){
        ErrorDataLog ioLog=new ErrorDataLog();
        Scanner read =new Scanner(System.in);
         
        int x=6,y=0,z,w; 
        try
        {
            System.out.println("Enter Number");
            w=read.nextInt();
            z=x/y;
        }catch(Exception error){
            StringWriter exceptionData =new StringWriter();
            error.printStackTrace(new PrintWriter(exceptionData));
            
            //senr to file
            ioLog.appendData(exceptionData.toString(),new GregorianCalendar().getTime() );
    
    }
    }
    
}
