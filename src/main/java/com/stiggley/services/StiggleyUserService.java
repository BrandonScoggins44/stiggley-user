package com.stiggley.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stiggley.models.StiggleyUser;
import com.stiggley.repositories.StiggleyUserRepository;

@Service
@Transactional
public class StiggleyUserService {

	@Autowired
	StiggleyUserRepository bamUserRepo;

	/**
	* Retrieves a List of all BamUsers from a database.
	* 
	*@return A List of all BamUsers from the database.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public List<StiggleyUser> findAllUsers() {
		return bamUserRepo.findAll();
	}

	/**
	* Retrieves a StiggleyUser from a database by their id.
	* 
	*@param id An Integer that identifies a StiggleyUser
	*@return A StiggleyUser from a database with a matching id.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public StiggleyUser findUserById(Integer id) {
		return bamUserRepo.findBamUserById(id);
	}

	/**
	* Adds a new StiggleyUser to a database and generates a unique id.
	* 
	*@param newUser The new StiggleyUser that will be added to the database.
	*@return The StiggleyUser that was added to the database with the generated id.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public StiggleyUser addUser(StiggleyUser newUser) {
		return bamUserRepo.save(newUser);
	}

	/**
	* Retrieves a StiggleyUser from a database by their email.
	* 
	*@param user A StiggleyUser object that at minimum contains an email field.
	*@return A complete StiggleyUser from a database with the matching email.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public StiggleyUser loginUser(StiggleyUser user) {
		return bamUserRepo.findBamUserByEmail(user.getEmail());
	}

	/**
	* Updates a StiggleyUser in a database.
	* 
	*@param updatedUser A StiggleyUser object that contains updated information.
	*@return The updated StiggleyUser object as it exist in the database.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public StiggleyUser updateUser(StiggleyUser updatedUser) {
		StiggleyUser user = bamUserRepo.findBamUserById(updatedUser.getId());
		
		if(user == null) {
			return user;
		} else {
			return bamUserRepo.save(updatedUser);
		}
	}
}
