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
import java.util.Properties;
import javax.mail.BodyPart;
 
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
 
public class GmailInbox {
 
    public static void main(String[] args) {
 
        GmailInbox gmail = new GmailInbox();
        gmail.read("vivek1.vejendla@gmail.com","ItachiUchiha");
 
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
            for (int i = 0; i < messages.length; i++) {
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
         System.out.println("Text Description: " + mbp1.getContent().toString());
                        
                        
                        
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