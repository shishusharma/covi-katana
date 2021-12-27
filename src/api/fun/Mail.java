package api.fun;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;






public class Mail{
    //static Connection con=(Connection) MyConnection.getConn();
    public Mail() {


    }

	/*
	 			int check=1;
	  			String to=txtEmail.getText();
		        String sub="OTP For Login To covi-katana";
		        String msg="This is System Generated Mail for COVID Vaccination and OTP is "+OTP+"";
		        lbl_otp.setText("OTP send to Eamil");
		        check=Mail.sendMail(msg,sub,to);
		        if(check==0)
					lbl_otp.setText("Please Enter Valid Email");
	 *
	 *
	 */

    public static int sendMail(String msg, String sub, String to) {
        int i=-1;
        String host="smtp.gmail.com";
        Properties prop=System.getProperties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("otpshishusharma@gmail.com","@Otp1989");
                    }
                });

        //session.setDebug(true);
        MimeMessage m= new MimeMessage(session);
        try {
            System.out.println("---->");
            m.setFrom("otpshishusharma@gmail.com");
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(sub);
            m.setText(msg);
            Transport.send(m);
            i=1;
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            i=0;
            e.printStackTrace();
        }

        return i;
    }

}











