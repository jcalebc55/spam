/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamfilter;

/**
 *
 * @author Caleb
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSearch {

    private static void insertIntoTable(String matched) {
         //To change body of generated methods, choose Tools | Templates.
         try {
         
             try {
                 try {
                     Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                      String host = "jdbc:derby://localhost:1527/sample";
                      String uname="app";
                      String passwd="app";
                     try {
                         Connection con = DriverManager.getConnection(host, uname,passwd);
                       Statement st = con.createStatement();   
                        //String q1 = "insert into dom_name values ('vivek')"; 
                        // st.executeUpdate(q1);
                         st.close();
                     } catch (SQLException ex) {
                         Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                     
                     
                     
                     
                     
                     
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                 }
             } catch (InstantiationException ex) {
                 Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IllegalAccessException ex) {
                 Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
             }
                    
                    
                    BufferedReader br = new BufferedReader(new FileReader(matched));
                    try {
                        
                        String line=null;
                        line=br.readLine();
//                        while(line !=null)
//                        {line=br.readLine();
//                        System.out.println(line);
//                        }
                        
                                
                    } catch (IOException ex) {
                        Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
         
         
         
    }

  private String fileNameToSearch;
  private List<String> result = new ArrayList<String>();

  public String getFileNameToSearch() {
	return fileNameToSearch;
  }

  public void setFileNameToSearch(String fileNameToSearch) {
	this.fileNameToSearch = fileNameToSearch;
  }

  public List<String> getResult() {
	return result;
  }

  public static void main(String[] args) {
             insertIntoTable("Hello");
	
  }

  public void searchDirectory(File directory, String fileNameToSearch) {

	setFileNameToSearch(fileNameToSearch);

	if (directory.isDirectory()) {
	    search(directory);
	} else {
	    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
	}

  }

  private void search(File file) {

	if (file.isDirectory()) {
	  System.out.println("Searching directory ... " + file.getAbsoluteFile());

            //do you have permission to read this directory?
	    if (file.canRead()) {
		for (File temp : file.listFiles()) {
		    if (temp.isDirectory()) {
			search(temp);
		    } else {
			if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {
			    result.add(temp.getAbsoluteFile().toString());
		    }

		}
	    }

	 } else {
		System.out.println(file.getAbsoluteFile() + "Permission Denied");
	 }
      }

  }

}