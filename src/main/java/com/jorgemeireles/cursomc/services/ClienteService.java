package com.jorgemeireles.cursomc.services;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jorgemeireles.cursomc.domain.Cliente;
import com.jorgemeireles.cursomc.repositories.ClienteRepository;
import com.jorgemeireles.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	// Vai no banco de dados e busca a categoria por ID
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}

}
