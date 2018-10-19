package com.stiggley.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stiggley.models.StiggleyUser;

@Repository
public interface StiggleyUserRepository extends JpaRepository<StiggleyUser, Integer> {

	/**
	* Retrieve a StiggleyUser from a database by their id.
	* 
	*@param  id The StiggleyUser id to be searched for.
	*@return The StiggleyUser with the given Id.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	StiggleyUser findStiggleyUserById(int id);

	/**
	* Retrieve a StiggleyUser from a database by their email.
	* 
	*@param  email The StiggleyUser email to be searched for.
	*@return The StiggleyUser with the given email.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	StiggleyUser findStiggleyUserByEmail(String email);
}
