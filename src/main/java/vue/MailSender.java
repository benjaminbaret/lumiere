package vue;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {

    public static void sendMail(String recepient, String firstName, String movieTitle, String roomName,
                                String dateSession, String startTime, String numberOfTicket) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "outlook.office365.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "benjaminafram@outlook.fr";
        String password = "lomep@le";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient, firstName, movieTitle, roomName, dateSession, startTime, numberOfTicket);
        Transport.send(message);
        System.out.println("Message sent !");
    }

    private static Message prepareMessage(Session session,String myAccountEmail, String recepient,
                                          String firstName, String movieTitle, String roomName,
                                          String dateSession, String startTime, String numberOfTicket) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Thanks for your reservation " + firstName + " !");
            message.setText("Hello "+firstName+", \n Thanks for your reservation at CinemaLumiere !" +
                    "\nHere's your order confirmation : \n" +
                    "- Movie : " + movieTitle +
                    "\n- Room Name : " + roomName +
                    "\n- Session Date : " + dateSession +
                    "\n- Time : " + startTime +
                    "\n- Number of tickets : " + numberOfTicket +
                    "\n\nSee you soon !" +
                    "\nRegards," +
                    "\nCinemaLumieres");

            return message;
        } catch (Exception ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
