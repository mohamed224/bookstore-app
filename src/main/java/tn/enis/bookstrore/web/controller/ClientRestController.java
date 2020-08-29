package tn.enis.bookstrore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.bookstrore.dao.ClientRepository;
import tn.enis.bookstrore.model.Client;
import tn.enis.bookstrore.service.IClientService;
import tn.enis.bookstrore.util.Credential;

@RestController
@CrossOrigin("*")
public class ClientRestController {

    private IClientService clientService;
    private ClientRepository clientRepository;

    @Autowired
    public ClientRestController(IClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients/login")
    public Client login(@RequestBody Credential credential) {
        return clientService.login(credential);
    }

    @PostMapping("/clients/register")
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }


    @PutMapping("/clients/resetPassword")
    public void resetPassword(@RequestParam("email") String email) {
        clientService.resetPassword(email);
    }

    @PutMapping("/clients/changePassword")
    public void changePassword(@RequestParam("email") String email, @RequestParam("oldPassword") String oldPassword,
                               @RequestParam("newPassword") String newPassword) {
        clientService.changePassword(email, oldPassword, newPassword);
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

}
