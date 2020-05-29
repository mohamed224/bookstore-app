package tn.enis.bookstrore.util.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class NotificationBuilder {

    private JavaMailSender javaMailSender;
    private Logger log = LoggerFactory.getLogger(NotificationBuilder.class);

    @Autowired
    public NotificationBuilder(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public SimpleMailMessage mailMessage(Mail mail){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSentDate(mail.getSendDate());
        mailMessage.setTo(mail.getTo());
        mailMessage.setFrom(mail.getFrom());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getBody());
        return mailMessage;
    }

    public void sendMail(SimpleMailMessage simpleMailMessage){
        try {
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }

}
