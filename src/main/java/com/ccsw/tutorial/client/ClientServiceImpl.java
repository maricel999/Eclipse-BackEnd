package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.exceptions.ExistsException;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client get(Long id) {

        return this.clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {

        return (List<Client>) this.clientRepository.findAll();
    }

    @Override
    public void save(Long id, ClientDto dto) throws ExistsException {
        List<Client> existingClient = this.clientRepository.findByName(dto.getName());

        if (existingClient.isEmpty()) {
            Client client = null;

            if (id == null)
                client = new Client();
            else
                client = this.clientRepository.findById(id).orElse(null);

            client.setName(dto.getName());

            this.clientRepository.save(client);
        } else
            throw new ExistsException();
    }

    @Override
    public void delete(Long id) {
        this.clientRepository.deleteById(id);
    }

}