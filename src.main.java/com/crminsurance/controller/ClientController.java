package com.crminsurance.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crminsurance.model.Client;
import com.crminsurance.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/client/", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> listAllUsers() {
        List<Client> clients = clientService.getClientList();
        if(clients.isEmpty()){
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") long id) {
        System.out.println("Fetching Client with id " + id);
        Client client = clientService.getClientById(id);
        if (client == null) {
            System.out.println("Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/client/", method = RequestMethod.POST)
    public ResponseEntity<Void> createClient(@RequestBody Client client,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Client " + client.getFirstName());
        /*
        if (clientService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return clientServicenew ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
 
        clientService.addClient(client);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateUser(@PathVariable("id") long id, @RequestBody Client client) {
        System.out.println("Updating Client " + id);
         
        Client currentClient = clientService.getClientById(id);
         
        if (currentClient==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
 
        currentClient.setFirstName(client.getFirstName());
        currentClient.setLastName(client.getLastName());
        currentClient.setEmail(client.getEmail());
        currentClient.setSource(client.getSource());
        currentClient.setStatus(client.getStatus());
        currentClient.setAmount(client.getAmount());
        currentClient.setIndustry(client.getIndustry());
        currentClient.setDescription(client.getDescription());
        
         
        clientService.updateClient(currentClient);
        return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
    }
 
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Client with id " + id);
 
        Client client = clientService.getClientById(id);
        if (client == null) {
            System.out.println("Unable to delete. Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
 
        clientService.deleteClient(id);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }
	
}
