/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Wladimir
 */
public class Correo {

    public String enviar(String mensaje, String destino, String asunto) {
        String servidorSMTP = "smtp.gmail.com";
        String puerto = "587";
        String usuario = "bherrera@unac.edu.co";
        String password = "94040202441";
        /* 
  String destino = "destino@correo.com";
  String asunto = "Prueba!";
  String mensaje = "Este es un mensaje de prueba.";
         */
        Properties props = new Properties();

        props.put("mail.debug", true);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", servidorSMTP);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getDefaultInstance(props);        
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    destino));
            message.setSubject(asunto);
            message.setSentDate(new Date());
            message.setText(mensaje);

            Transport tr = session.getTransport("smtp");
            tr.connect(servidorSMTP, usuario, password);
            message.saveChanges();
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "hola";
    }
}

