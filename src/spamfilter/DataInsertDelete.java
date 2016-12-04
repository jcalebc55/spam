/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamfilter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caleb
 */
public class DataInsertDelete {
     public static void insertDomain(String InsStr){
         try {
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         }
                      String host = "jdbc:derby://localhost:1527/sample";
                      String uname="app";
                      String passwd="app";
                      
                      try {
                         Connection con = DriverManager.getConnection(host, uname,passwd);
                       Statement st = con.createStatement();   
                        String q1 = "insert into TEST_DOMAIN values ('"+InsStr+"')"; 
                        st.executeUpdate(q1);
                         st.close();
                     } catch (SQLException ex) {
                         Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      
                  
         
     }
     
     
     
     
     
     public static boolean domainContains(String InsStr){
         boolean b=false;
         try {
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         }
                      String host = "jdbc:derby://localhost:1527/sample";
                      String uname="app";
                      String passwd="app";
                      
                      try {
                         Connection con = DriverManager.getConnection(host, uname,passwd);
                       Statement st = con.createStatement();   
                        String q1 = "select DOMAIN_NAME from TEST_DOMAIN where DOMAIN_NAME='"+InsStr+"'"; 
                         ResultSet rs=st.executeQuery(q1);
                         b=rs.next();
                         st.close();
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      
                  
         return b;
     }
     
     
     public static boolean UrlContains(String InsStr){
         boolean b=false;
         try {
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         }
                      String host = "jdbc:derby://localhost:1527/sample";
                      String uname="app";
                      String passwd="app";
                      
                      try {
                         Connection con = DriverManager.getConnection(host, uname,passwd);
                       Statement st = con.createStatement();   
                        String q1 = "select url_NAME from TEST_URL where URL_NAME='"+InsStr+"'"; 
                         ResultSet rs=st.executeQuery(q1);
                         b=rs.next();
                         st.close();
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      
                  
         return b;
     }
     
     
     
     
     public static void insertUrl(String InsStr){
         try {
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         }
                      String host = "jdbc:derby://localhost:1527/sample";
                      String uname="app";
                      String passwd="app";
                      
                      try {
                         Connection con = DriverManager.getConnection(host, uname,passwd);
                       Statement st = con.createStatement();   
                        String q1 = "insert into TEST_URL values ('"+InsStr+"')"; 
                        st.executeUpdate(q1);
                         st.close();
                     } catch (SQLException ex) {
                         Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      
                  
         
     }
     
     
     
     
     public static void deleteDomain(String InsStr){
         try {
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         }
                      String host = "jdbc:derby://localhost:1527/sample";
                      String uname="app";
                      String passwd="app";
                      
                      try {
                         Connection con = DriverManager.getConnection(host, uname,passwd);
                       Statement st = con.createStatement();   
                        String q1 = "delete from TEST_domain where domain_name= ('"+InsStr+"')"; 
                        st.executeUpdate(q1);
                         st.close();
                     } catch (SQLException ex) {
                         Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      
                  
         
     }
     
     
     
     public static void deleteURL(String InsStr){
         try {
             Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(DataInsertDelete.class.getName()).log(Level.SEVERE, null, ex);
         }
                      String host = "jdbc:derby://localhost:1527/sample";
                      String uname="app";
                      String passwd="app";
                      
                      try {
                         Connection con = DriverManager.getConnection(host, uname,passwd);
                       Statement st = con.createStatement();   
                        String q1 = "delete from TEST_URL where url_name= ('"+InsStr+"')"; 
                        st.executeUpdate(q1);
                         st.close();
                     } catch (SQLException ex) {
                         Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      
                  
         
     }
     
     
     
     
     
    public static void main(String args[]){
         System.out.println("Hello ");
         boolean test;
         test = UrlContains("Jabez1");
         System.out.println("Domain contains"+test);
     //   insertDomain("test@testmail.com");
       // insertDomain("test@gmail.com");
         //insertUrl("Jabez1");
         //deleteDomain("Vivek");
        
       //deleteURL("TestUrl");
     }
    
}
