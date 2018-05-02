package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {

	public List<Client> getAllClient();

	public Client addClient(Client cl);

	public Client updateClient(Client cl);

	public int deleteClient(int id);

	public Client getClientById(int id);

}
