package com.seye.banque;

import com.seye.banque.dao.ClientRepository;
import com.seye.banque.dao.CompteRepository;
import com.seye.banque.dao.OperationRepository;
import com.seye.banque.entities.Client;
import com.seye.banque.entities.Compte;
import com.seye.banque.entities.CompteCourant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MabanqueApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	public static void main(String[] args) {
		SpringApplication.run(MabanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Client
	    Client client1 = clientRepository.save(new Client("Baye ndemba SEYE","bayendemba@gmail.com"));
		Client client2 = clientRepository.save(new Client("Ndeye Coumba SAMB","ndeycsamb@gmail.com"));
		Client client3 = clientRepository.save(new Client("Saliou","saliou@gmail.com"));
		// Compte
        Compte compte1 = compteRepository.save(new CompteCourant("c1",new Date(),120000,client1,1000));
        Compte compte2 = compteRepository.save(new CompteCourant("c2",new Date(),652000,client2,900));
        Compte compte3 = compteRepository.save(new CompteCourant("c2",new Date(),652000,client2,900));



	}
}
