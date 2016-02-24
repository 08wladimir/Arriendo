/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import com.sun.xml.internal.ws.message.MimeAttachmentSet;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Wladimir
 */
public class Email {    
    
    public boolean enviar(String correo, String mensaje, String asunto) throws MessagingException{
        try{
        Properties p = new Properties();
        p.put("mail.smtp.com", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.user", "bherrera@unac.edu.co");
        p.setProperty("mail.smtp.auth", "true");
        
        Session s = Session.getDefaultInstance(p, null);
        BodyPart texto = new MimeBodyPart();
        texto.setText(mensaje);
        MimeMultipart m = new MimeMultipart();
        m.addBodyPart(texto);
        MimeMessage mensaj = new MimeMessage(s);
        mensaj.setFrom(new InternetAddress("bherrera@unac.edu.co"));
        mensaj.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
        mensaj.setSubject(asunto);
        mensaj.setContent(m);
        
        Transport t = s.getTransport("smtp");
        t.connect("bherrera@unac.edu.co","94040202441");
        t.sendMessage(mensaj, mensaj.getAllRecipients());
        t.close();
        return true;
        
        } catch(Exception e){
            return false;
        }
        
        
    }
    
}
