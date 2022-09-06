package com.mydemo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Service;

import com.mydemo.DTO.Cliente;
import com.mydemo.repository.ClienteRepository;


@EnableSpringDataWebSupport
@ComponentScan(basePackageClasses = com.mydemo.repository.ClienteRepository.class)
@Service

public class ClienteService {

	private static final Logger logger = LogManager.getLogger(ClienteService.class);

	@SuppressWarnings("unused")
	@Autowired
	private ClienteRepository clienteRepo;

	//ClienteService service = new ClienteService(clienteRepo);

	//public ClienteService(ClienteRepository repository) {
	//	this.clienteRepo = repository;
	//}

	// public void setRepository(ClienteRepository repository) {
	// this.clienteRepo = repository;
	// }

	public List<Cliente> getClientes() throws Exception {
		try {
			logger.trace("Retrieving data from database");
			if (!clienteRepo.findAll().isEmpty() == true) {
				List<Cliente> lista = clienteRepo.findAll();
				return lista;
			}

		} catch (Exception ex) {
			logger.error("Error during the execution" + ex.getCause());

		}
		return null;

	}

}
