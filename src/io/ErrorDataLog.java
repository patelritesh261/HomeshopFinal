/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author ritesh
 */
public class ErrorDataLog {
    private void checkDirectory()
    {
        try
        {
            File directory=new File("C:/IOTest");
            //check if directory exists
            if(!directory.exists()){
                //create directory
                if(directory.mkdir()){
                    System.out.println("Directory Created!");
                }
                else
                {
                     System.out.println("Failed to create directory!");
                }
            }
            
        }
        catch(SecurityException error){
            error.printStackTrace();
        }
        catch(Exception error){
            error.printStackTrace();
        }
    }
     public void appendData(String Data,Date currentDateTime){
        //check the directory
        checkDirectory();
        
        try{
            File file=new File("c:/IOTest/NewFile.txt");
            
            if(!file.exists())
            {
                file.createNewFile();
            }
            //create the file writer
            FileWriter fwriter=new FileWriter(file,true);
            BufferedWriter bWriter=new BufferedWriter(fwriter);
            
            bWriter.write("\n*************************Error Log **********************************\n\n"+currentDateTime.toString()+
                    "\n"+Data+"\n\n**********************************Error Log End**********************************************************\n");
            bWriter.newLine();
            bWriter.close();
        }catch(IOException error){
            error.printStackTrace();
        }
        catch(Exception error){
            error.printStackTrace();
        }
    }
       public void readDataBR(){
        BufferedReader br=null;
        try
        {
            String currentLine;
            br=new BufferedReader(new FileReader("c:/IOTest/NewFile.txt"));
            
            currentLine=br.readLine();
            
            while(currentLine!=null){
                System.out.println(currentLine);
                currentLine=br.readLine();
            }
            br.close();
        }
        catch(IOException error){
            error.printStackTrace();
        }
        catch(Exception error){error.printStackTrace();}
    }
    
}
