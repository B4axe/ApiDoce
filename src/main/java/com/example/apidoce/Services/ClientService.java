package com.example.apidoce.Services;

import com.example.apidoce.Models.ClientEntity;
import com.example.apidoce.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

   public List<ClientEntity> findAll(){
       return clientRepository.findAll();
   }

   public boolean isAdm(String id){
       Optional<ClientEntity> client =  clientRepository.findById(id);
       if (client.isPresent()){
           return client.get().isAdm();
       }
       return false;
   }

    public ClientEntity login(String email, String password) {
        Optional<ClientEntity> client = clientRepository.findByEmailAndPassword(email, password);

        if (client.isPresent()) {
            return client.get();
        }
        throw new RuntimeException("Credenciais inválidas!");
    }
}
