/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author faouzia
 */
public class SendMail {
     static final String username = "sitewebstore@gmail.com";
    static final String password = "ubkcugxexbycggit";
    public static boolean send(String s,String email) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sitewebstore@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(email));
            message.setSubject("lien de confirmation");
            message.setText(s);
            Transport.send(message);
            System.out.println("Done");
            return true;
        } catch (MessagingException e) {
                return false;
        }
}
}
