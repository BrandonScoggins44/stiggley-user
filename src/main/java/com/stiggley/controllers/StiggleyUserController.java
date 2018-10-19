package com.stiggley.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stiggley.models.StiggleyUser;
import com.stiggley.services.StiggleyUserService;

@CrossOrigin
@RestController
@RequestMapping
public class StiggleyUserController {

	@Autowired
	StiggleyUserService stiggleyUserService;

	private static final Logger logger = LogManager.getLogger(StiggleyUserController.class);

	/**
	 * Retrieves a List of all StiggleyUsers from a database.
	 *
	 * @return A List of StiggleyUsers from a database, and a corresponding Http Status
	 *         Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StiggleyUser>> findAllUsers() {
		logger.info("[DEBUG] - in StiggleyUserController.findAllUsers()");
		List<StiggleyUser> allUsers = stiggleyUserService.findAllUsers();

		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	/**
	 * Retrieves a specific StiggleyUser from a database by their id.
	 * 
	 * @param id
	 *            An id that uniquely identifies a StiggleyUser in the database
	 * @return A StiggleyUser matching the pathVariable id, and a corresponding Http
	 *         Status Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StiggleyUser> findUserById(@PathVariable("id") int id) {
		logger.info("[DEBUG] - in StiggleyUserController.findUserById()");

		StiggleyUser user = stiggleyUserService.findUserById(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	/**
	 * Takes a StiggleyUser object from a request body, and persist it to a database.
	 * 
	 * @param newUser
	 *            The new StiggleyUser to be added to the database
	 * @return The StiggleyUser that was added to the database with its generated id, and
	 *         a corresponding Http Status Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StiggleyUser> addUser(@Valid @RequestBody StiggleyUser newUser) {
		logger.info("[DEBUG] - in StiggleyUserController.addUser()");
		StiggleyUser user = stiggleyUserService.addUser(newUser);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	/**
	 * Uses the email property of a StiggleyUser object from the request body to retrieve
	 * a full StiggleyUser object from a database.
	 *
	 * @param user
	 *            A StiggleyUser object containing at minimum an email field
	 * @return A StiggleyUser from the database that corresponds to the unique email
	 *         found in the request body, and a corresponding Http Status Code in a
	 *         ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StiggleyUser> loginUser(@RequestBody StiggleyUser user) {
		logger.info("[DEBUG] - in StiggleyUserController.loginUser()");
		StiggleyUser loggedUser = stiggleyUserService.loginUser(user);

		if (loggedUser == null) {
			return new ResponseEntity<>(loggedUser, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
		}
	}

	/**
	 * Takes a StiggleyUser object from a request body, and updates it in a database.
	 * 
	 * @param updatedUser
	 *            An updated StiggleyUser that is to be updated in the database
	 * @return The updated StiggleyUser object as it exist in the database, and a
	 *         corresponding Http Status Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StiggleyUser> updateUser(@RequestBody StiggleyUser updatedUser) {
		logger.info("[DEBUG] - in StiggleyUserController.updateUser()");
		StiggleyUser user = stiggleyUserService.updateUser(updatedUser);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
