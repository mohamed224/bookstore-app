package tn.enis.bookstrore.service;

import tn.enis.bookstrore.model.Client;

public interface INotificationService {

    void resetPasswordNotification(String email,String newPassword);
}
