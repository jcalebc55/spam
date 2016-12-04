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
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
 
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
 
public class GmailInbox {
    
    int maillength;

    public GmailInbox(int length) {
    maillength=length;
    }
    
    
 
    public static void main(String[] args) {
 
        GmailInbox gmail = new GmailInbox(1453);
        //gmail.read("vivek1.vejendla@gmail.com","ItachiUchiha");
        ArrayList<String> DomainNameStrings = new ArrayList<String>();
        ArrayList<String> DomainNames=gmail.getDomainNames("vivek1.vejendla@gmail.com","ItachiUchiha");
        int i=0;
        
        for(String domain:DomainNames){
            try{String domainSub;
           if(domain.contains("<"))
           {domainSub=domain.substring(domain.indexOf("<") + 1, domain.indexOf(">"));}
           else {domainSub=domain;}
            //System.out.println(" Domain no:"+i+" "+domainSub);
            DomainNameStrings.add(domainSub);
            i++;}catch(Exception e){System.out.println("Exception Caught");
                
            }
        }
        i=0;
        for(String domain:DomainNameStrings){
            i++;
        System.out.println(domain);
        }
        
        
 
    }
    
    public ArrayList<String> getDomainNames(String email, String password) {
 
        Properties props = new Properties();
 
        try {
            props.load(new FileInputStream(new File("/home/Caleb/Desktop/FinalProject/smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);
 
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", email, password);
 
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
 
            System.out.println("Total Messages:- " + messageCount);
             ArrayList<String> domainNames = new ArrayList<String>();
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
 int count=0;
            for (int i = 0; i < maillength; i++) {
                Message message=messages[i];
                
                        if(message.isMimeType("multipart/*")){count++;
                       
                        //  Multipart mmp = new Multipart();
          //BodyPart mbp1 = new BodyPart();
       //if(  message.isMimeType("multipart/*")){
           Multipart mmp = (Multipart) message.getContent();
           BodyPart mbp1 = (BodyPart) mmp.getBodyPart(0);
         //System.out.println("---------------------------------");
         //System.out.println("Email Number " + (i + 1));
         //System.out.println("Subject: " + message.getSubject());
         //System.out.println("From: " + message.getFrom()[0]);
        
         
         domainNames.add(message.getFrom()[0].toString());
         //System.out.println("Text: " + message.getContent().toString());
    //     System.out.println("Text Description: " + mbp1.getContent().toString());
                        
                        
                        
                        }
                //System.out.println("Mail Subject:- " + message.getContent());
                
                
            }
            
 
            inbox.close(true);
            store.close();
 
            return domainNames;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
    
    
 
    public void read(String email, String password) {
 
        Properties props = new Properties();
 
        try {
            props.load(new FileInputStream(new File("/home/Caleb/Desktop/FinalProject/smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);
 
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", email, password);
 
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
 
            System.out.println("Total Messages:- " + messageCount);
 
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
 int count=0;
            for (int i = 0; i < maillength; i++) {
                Message message=messages[i];
                
                        if(message.isMimeType("multipart/*")){count++;
                       
                        //  Multipart mmp = new Multipart();
          //BodyPart mbp1 = new BodyPart();
       //if(  message.isMimeType("multipart/*")){
           Multipart mmp = (Multipart) message.getContent();
           BodyPart mbp1 = (BodyPart) mmp.getBodyPart(0);
         System.out.println("---------------------------------");
         System.out.println("Email Number " + (i + 1));
         System.out.println("Subject: " + message.getSubject());
         System.out.println("From: " + message.getFrom()[0]);
         //System.out.println("Text: " + message.getContent().toString());
    //     System.out.println("Text Description: " + mbp1.getContent().toString());
                        
                        
                        
                        }
                //System.out.println("Mail Subject:- " + message.getContent());
                
                
            }
            
 
            inbox.close(true);
            store.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}