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
import java.util.Properties;
import javax.mail.BodyPart;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;



public class SpamFilter {
 public static void check(String host, String storeType, String user,
      String password) 
   {
      try {

      //create properties field
      Properties properties = new Properties();

      properties.put("mail.pop3.host", host);
      properties.put("mail.pop3.port", "995");
      properties.put("mail.pop3.starttls.enable", "true");
      Session emailSession = Session.getDefaultInstance(properties);
  
      //create the POP3 store object and connect with the pop server
      Store store = emailSession.getStore("pop3s");

      store.connect(host, user, password);

      //create the folder object and open it
      Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_ONLY);

      // retrieve the messages from the folder in an array and print it
      Message[] messages = emailFolder.getMessages();
      System.out.println("messages.length---" + messages.length);

      for (int i = 0, n = messages.length; i < n; i++) {
         Message message = messages[i];
            //  Multipart mmp = new Multipart();
          //  BodyPart mbp1 = new BodyPart();
       if(  message.isMimeType("multipart/*")){
           Multipart mmp = (Multipart) message.getContent();
           BodyPart mbp1 = (BodyPart) mmp.getBodyPart(0);
         System.out.println("---------------------------------");
         System.out.println("Email Number " + (i + 1));
         System.out.println("Subject: " + message.getSubject());
         System.out.println("From: " + message.getFrom()[0]);
         System.out.println("Text: " + message.getContent().toString());
         System.out.println("Text Description: " + mbp1.getContent().toString());
      }
                

      }

      //close the store and folder objects
      emailFolder.close(false);
      store.close();

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          String host = "pop.gmail.com";// change accordingly
      String mailStoreType = "pop3";
      String username = "vivek1.vejendla@gmail.com";// change accordingly
      String password = "ItachiUchiha";// change accordingly

      check(host, mailStoreType, username, password);

        
        
    }
    
}
