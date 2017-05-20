package com.crminsurance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.crminsurance.model.Client;

public class ClientDaoImpl implements ClientDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;

	public boolean addClient(Client client) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(client);
		tx.commit();
		session.close();
		return true;
	}

	public Client getClientById(long id) {
		session = sessionFactory.openSession();
		Client client = (Client) session.load(Client.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return client;
	}

	public List<Client> getClientList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Client> clientList = session.createCriteria(Client.class).list();
		tx.commit();
		session.close();
		return clientList;
	}

	public boolean deleteClient(long id) {
		session = sessionFactory.openSession();
		Object o = session.load(Client.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return true;
	}

	public boolean updateClient(Client client) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.persist(client);
		tx.commit();
		return true;
	}

}


/*
public boolean updateClient(Client client) {
	session = this.sessionFactory.getCurrentSession();
	tx = session.beginTransaction();
	session.update(client);
	tx.commit();
	return true;
}
*/
