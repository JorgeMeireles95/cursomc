package com.jorgemeireles.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgemeireles.cursomc.domain.Pedido;
import com.jorgemeireles.cursomc.repositories.PedidoRepository;
import com.jorgemeireles.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	// Vai no banco de dados e busca a categoria por ID
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}

}
