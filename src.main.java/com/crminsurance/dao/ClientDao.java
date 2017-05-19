package com.crminsurance.dao;

import java.util.List;

import com.crminsurance.model.Client;

public interface ClientDao {
	public boolean addClient(Client client);
	public Client getClientById(long id);
	public List<Client> getClientList();
	public boolean deleteClient(long id);
	public boolean updateClient(Client client);	
}
