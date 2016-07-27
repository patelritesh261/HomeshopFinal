/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;
import java.io.*;
import java.util.*;
import java.security.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ritesh
 */
public class FileDataWriter {
    FileOutputStream outStream;
    File file;
    
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
    private void CreateFile(){
        try{
            //check the directory
            checkDirectory();
            //create the file
            file =new File("c:/IOTest/NewFile.txt");
            outStream=new FileOutputStream(file);
            //if the file does not exists, created  it.
            if(!file.exists())
            {
                file.createNewFile();
            }
        }
        catch(IOException error)
        {
            error.printStackTrace();
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
    }//end create file
    public void writeData(String data){
        //try to create a file
        CreateFile();
        try{
            byte[] stringToBytes= data.getBytes();
            //write the data to the stream
            outStream.write(stringToBytes);
            outStream.flush();
            outStream.close();
            
            System.out.println("File write complete.");
        }
        catch(IOException error){
            error.printStackTrace();
        }
        catch(Exception error){
            error.printStackTrace();
        }
    }
    public void appendData(String Data){
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
            
            bWriter.write(Data);
            bWriter.newLine();
            bWriter.close();
        }catch(IOException error){
            error.printStackTrace();
        }
        catch(Exception error){
            error.printStackTrace();
        }
    }
    public void readFileData()
    {
        try{
            
            JFileChooser chooser=new JFileChooser();
            chooser.showOpenDialog(chooser);
            File file=chooser.getSelectedFile();
            if (file==null)
            {
                file=new File("c:/IOTest/NewFile.txt");
            }
            //File file=new File("c:/IOTest/NewFile.txt");
            FileInputStream inStream=new FileInputStream(file);
            int content;
            
            content=inStream.read();
            while(content!=-1)
            {
                System.out.print((char)content);
                content=inStream.read();
            }
            inStream.close();
        }
        catch(IOException error)
        {
            error.printStackTrace();
        }
        catch(Exception error)
        {
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
    public static void main(String[] args)
    {
        FileDataWriter myIO=new FileDataWriter();
        
        //myIO.writeData("ohhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh.");
        myIO.appendData("Name : Ritesh Patel");
        myIO.appendData("ID : 200307232");
        myIO.appendData("Assignment : File Writer");
        
        //myIO.readFileData();
        myIO.readDataBR();
    }
}
