package com.mydemo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mydemo.DTO.Cliente;
import com.mydemo.repository.ClienteRepository;

@RestController(value = "/v1/api/cliente")
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackageClasses = com.mydemo.repository.ClienteRepository.class)
public class ClienteControllerApi {

	private static final Logger logger = LogManager.getLogger(ClienteControllerApi.class);

	@Autowired
	//@Qualifier(value = "clienteRepo")
	private ClienteRepository clienteRepo;
	
	
	/*
	@Autowired
	//@Qualifier(value = "servicoRepo")
	private ServicoRepository servicoRepo;
	*/
	
	
	
	@ResponseBody
	@RequestMapping("/ola")
	public String getHello() {
		return "<h1> Sys- Vendas</h1>"; 
	}

	//private ClienteService service = new ClienteService(this.clienteRepo);

	@GetMapping(value = "/v1/api/cliente/all" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CacheEvict(allEntries = true)
	@Transactional
	public List<Cliente> listAllClientes() throws Exception {
		try {
			logger.debug("Trying to retrieve values from client Entity");
			if (!clienteRepo.findAll().isEmpty() == true) {
				List<Cliente> lista = clienteRepo.findAll();
				return lista;
			} else {
				logger.error("Table is empty");
				return null;
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex.getCause());
		}
	}
	
	
	


}
