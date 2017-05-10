package com.crminsurance.services;

import java.util.List;

import com.crminsurance.model.Client;

public interface ClientService {
	public boolean addClient(Client client);
	public Client getClientById(long id);
	public List<Client> getClientList();
	public boolean deleteClient(long id);
}
