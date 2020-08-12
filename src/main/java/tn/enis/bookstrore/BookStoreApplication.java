package tn.enis.bookstrore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.enis.bookstrore.service.IClientService;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    @Autowired
    private IClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        //clientService.resetPassword("mdiaby00@gmail.com");
        //clientService.changePassword("mdiaby00@gmail.com","32xf$)jm","12345");
    }
}
