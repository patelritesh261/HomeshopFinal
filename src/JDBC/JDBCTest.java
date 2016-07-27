/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import io.ErrorDataLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.GregorianCalendar;

/**
 *
 * @author ritesh
 */
public class JDBCTest {
    //variable declration
    DBConnect db = new DBConnect();
    Statement stat = null;
    Connection conn = null;
    ResultSet rs = null;
 //create class object
   
    ErrorDataLog ioLog = new ErrorDataLog();
  

    public String selectData(String sqlQuery, String columnName) {
        ResultSetMetaData metaData = null;
        String Strlist = "";
        try {
            conn = db.getConnection();
            //create statement
            stat = conn.createStatement();
            //execute query to get result set
            rs = stat.executeQuery(sqlQuery);

            metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                //  for(int i=1;i<columnCount;i++){
                Strlist += rs.getString(columnName) + "/";
                //System.out.println(Strlist);
                //  }//end for
            }//end while

        } catch (SQLException error) {
            //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "selectData", new GregorianCalendar().getTime());
        } catch (Exception error) {
            //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "selectData", new GregorianCalendar().getTime());
        }
        return Strlist;
    }

    public String selectDataAll(String sqlQuery) {
        ResultSetMetaData metaData = null;
        String Strlist = "";
        try {
            conn = db.getConnection();
            //create statement
            stat = conn.createStatement();
            //execute query to get result set
            rs = stat.executeQuery(sqlQuery);

            metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Strlist += metaData.getColumnName(i) + ": \t"
                            + rs.getObject(i) + "\n";
                    //System.out.println(Strlist);
                }//end for
            }//end while

        } catch (SQLException error) {
            //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "selectDataAll", new GregorianCalendar().getTime());
        } catch (Exception error) {
            //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "selectDataAll", new GregorianCalendar().getTime());
        }
        return Strlist;
    }
    //create insert method
    public void insertData(String Sqlquery) {
        DBConnect db = new DBConnect();
        Statement stat = null;
        Connection conn = null;
       //  final String DB_URL="jdbc:mysql://sql.computerstudi.es:3306/gc200307232";

        try {
            // conn=DriverManager.getConnection(DB_URL, "gc200307232", "GuDgA?sA");
            conn = db.getConnection();
            stat = conn.createStatement();
            //execute query
            stat.execute(Sqlquery);
            
            stat.close();
            conn.close();
        } catch (SQLException error) {
           //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "insertData", new GregorianCalendar().getTime());
        } catch (Exception error) {
            //write data in error log..
                        StringWriter exceptionData = new StringWriter();
                        error.printStackTrace(new PrintWriter(exceptionData));

                        //sent to file
                        ioLog.appendData(exceptionData.toString(), new GregorianCalendar().getTime());
                        //save errorlog in database
                        saveErrorLogDB(exceptionData.toString(), "insertData", new GregorianCalendar().getTime());
        }

    }
    //methods for save error log to DB

    private void saveErrorLogDB(String errorlog, String field, java.util.Date time) {
        //create SQL Query
        String Sqlquery = "INSERT INTO `errorLog`( `panelName`,`fieldName`, `errorMsg`, `time`) "
                + "VALUES ('Database Error','" + field + "','" + errorlog + "','" + time + "');";
        //call insert Method
        insertData(Sqlquery);
    }
}
