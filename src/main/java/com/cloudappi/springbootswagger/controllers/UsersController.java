package com.cloudappi.springbootswagger.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudappi.springbootswagger.dao.UsersDAO;
import com.cloudappi.springbootswagger.entities.Address;
import com.cloudappi.springbootswagger.entities.User;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	private UsersDAO userDAO;

	// Devuelve lista usuarios
	@GetMapping(value = "getusers") // users/getusers
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userDAO.findAll();
		return ResponseEntity.ok(users);
	}

	// Devuelve un usuario por el ID
	@GetMapping(value = "getusersById/{userId}") // users/getusersById/{userId} -> //users/getusersById/1
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
		Optional<User> optionalUser = userDAO.findById(userId);
		// Preguntamos si existe el objeto y recibimos respuesta
		if (optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		} else {
			return ResponseEntity.noContent().build();
		}

	}

	// Crear un usuario
	@PostMapping(value = "createUsers")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userDAO.save(user);
		return ResponseEntity.ok(newUser);
	}

	// Modificar un usuario
	@PutMapping(value = "updateUsersById/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") int userId) {
		Optional<User> optionalUser = userDAO.findById(userId);

		// Preguntamos si existe el ID del objeto y recibimos respuesta
		if (optionalUser.isPresent()) {
			User updateUser = optionalUser.get();
			updateUser.setName(user.getName());
			updateUser.setEmail(user.getEmail());
			updateUser.setBirthDate(user.getBirthDate());
			updateUser.setAddress(user.getAddress());
			userDAO.save(updateUser);
			return ResponseEntity.ok(updateUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Borrar un usuario
	@DeleteMapping(value = "deleteUsersById/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId) {
		userDAO.deleteById(userId);
		return ResponseEntity.ok(null);
	}
	
	
}
