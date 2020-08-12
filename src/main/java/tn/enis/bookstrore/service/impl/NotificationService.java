package tn.enis.bookstrore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import tn.enis.bookstrore.service.INotificationService;
import tn.enis.bookstrore.util.constants.ConstantsValue;
import tn.enis.bookstrore.util.notification.Mail;
import tn.enis.bookstrore.util.notification.NotificationBuilder;

import java.util.Date;

@Service
public class NotificationService implements INotificationService {

    private NotificationBuilder notificationBuilder;
    private Mail mail;

    @Autowired
    public NotificationService(NotificationBuilder notificationBuilder) {
        this.notificationBuilder = notificationBuilder;
        this.mail = new Mail();
    }

    @Override
    public void resetPasswordNotification(String email, String newPassword) {
        this.mail.setTo(email);
        this.mail.setSendDate(new Date());
        this.mail.setSubject(ConstantsValue.RESET_PASSWORD_SUBJECT);
        this.mail.setBody("Ceci: " + newPassword + " est votre nouveau mot de passe, vous devez le modifier avant de continuer votre navigation.\n\n\n Cordialement");
        SimpleMailMessage mailMessage = notificationBuilder.mailMessage(this.mail);
        notificationBuilder.sendMail(mailMessage);

    }
}
