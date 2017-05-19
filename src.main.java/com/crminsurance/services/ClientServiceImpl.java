package com.crminsurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crminsurance.dao.ClientDao;
import com.crminsurance.model.Client;

public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientDao clientDao;

	public boolean addClient(Client client) {
		return clientDao.addClient(client);
	}

	public Client getClientById(long id) {
		return clientDao.getClientById(id);
	}

	public List<Client> getClientList() {
		return clientDao.getClientList();
	}

	public boolean deleteClient(long id) {
		return clientDao.deleteClient(id);
	}

	public boolean updateClient(Client client) {
		return clientDao.updateClient(client);
	}

}
