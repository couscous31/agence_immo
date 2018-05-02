package fr.adaming.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clDao;

	@Override
	public List<Client> getAllClient() {
		return clDao.getAllClient();
	}

	@Override
	public Client addClient(Client cl) {
		return clDao.addClient(cl);
	}

	@Override
	public Client updateClient(Client cl) {
		return clDao.updateClient(cl);
	}

	@Override
	public int deleteClient(int id) {
		return clDao.deleteClient(id);
	}

	@Override
	public Client getClientById(int id) {
		return clDao.getClientById(id);
	}

}
