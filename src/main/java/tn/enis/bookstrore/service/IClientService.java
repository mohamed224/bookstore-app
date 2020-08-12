package tn.enis.bookstrore.service;

import tn.enis.bookstrore.model.Client;
import tn.enis.bookstrore.util.Credential;

public interface IClientService {

    Client login(Credential credential);

    Client saveClient(Client client);

    void resetPassword(String email);

    void changePassword(String email, String oldPassword, String newPassword);
}
