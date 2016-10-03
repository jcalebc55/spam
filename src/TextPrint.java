
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caleb
 */
public class TextPrint {
    
    
    public static void main(String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("/home/Caleb/Desktop/URLS/blacklists/updatesites/domains"));
                    String line=null;
                        do 
                        {try {
                            line=br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(TextPrint.class.getName()).log(Level.SEVERE, null, ex);
                }
                        {System.out.println(line);}
}
                        while(line!=null)
                                



        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
