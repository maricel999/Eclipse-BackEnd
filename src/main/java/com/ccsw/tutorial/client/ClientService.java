package com.ccsw.tutorial.client;

import java.util.List;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.exceptions.ExistsException;

public interface ClientService {

    Client get(Long id);

    List<Client> findAll();

    void save(Long id, ClientDto dto) throws ExistsException;

    void delete(Long id);
}