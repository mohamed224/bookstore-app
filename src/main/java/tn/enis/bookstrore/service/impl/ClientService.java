package tn.enis.bookstrore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.enis.bookstrore.dao.ClientRepository;
import tn.enis.bookstrore.model.Client;
import tn.enis.bookstrore.service.IClientService;
import tn.enis.bookstrore.service.INotificationService;
import tn.enis.bookstrore.util.Credential;
import tn.enis.bookstrore.util.RandomPasswordGenerator;

@Service
public class ClientService implements IClientService {

    private ClientRepository clientRepository;
    private RandomPasswordGenerator randomPasswordGenerator;
    private PasswordEncoder encoder;
    private INotificationService notificationService;

    @Autowired
    public ClientService(ClientRepository clientRepository, RandomPasswordGenerator randomPasswordGenerator, PasswordEncoder encoder, INotificationService notificationService) {
        this.clientRepository = clientRepository;
        this.randomPasswordGenerator = randomPasswordGenerator;
        this.encoder = encoder;
        this.notificationService = notificationService;
    }

    @Override
    public Client login(Credential credential) {
        Client client = clientRepository.findByEmail(credential.getEmail());
        if(client==null || !encoder.matches(credential.getPassword(),client.getPassword())){
            throw new BadCredentialsException("Bad Credentials");
        }
        return client;
    }

    @Override
    public Client saveClient(Client client) {
        String encodedPassword = encoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        return clientRepository.save(client);
    }

    @Override
    public void resetPassword(String email) {
        Client client = clientRepository.findByEmail(email);
        if(client==null){
            throw new RuntimeException();
        }
        String newPassword = randomPasswordGenerator.generatePassword();
        String encodedPassword = encoder.encode(newPassword);
        client.setPassword(encodedPassword);
        clientRepository.saveAndFlush(client);
        notificationService.resetPasswordNotification(email,newPassword);
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        Client client = clientRepository.findByEmail(email);
        if(client==null){
            throw new RuntimeException("Ce client n'existe pas.");
        }
        if(encoder.matches(oldPassword,client.getPassword())){
            String encodedPassword = encoder.encode(newPassword);
            client.setPassword(encodedPassword);
            clientRepository.saveAndFlush(client);
        }else{
            throw new RuntimeException("Votre mot de passe n'est pas correct");
        }
    }
}
