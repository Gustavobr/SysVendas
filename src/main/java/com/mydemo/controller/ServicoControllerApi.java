package com.mydemo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mydemo.DTO.Servico;
import com.mydemo.repository.ServicoRepository;

@RestController(value = "/v1/api/servico")
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackageClasses = com.mydemo.repository.ServicoRepository.class)
public class ServicoControllerApi {

	private static final Logger logger = LogManager.getLogger(ServicoControllerApi.class);

	@Autowired
	private ServicoRepository servicoRepo;

	@Description("Endpoint to get a specific service")
	@RequestMapping(value = "/v1/api/servico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus
	//
	public com.mydemo.DTO.Servico getServicoId(@PathVariable Long id) throws Exception {
		try {
			if (id != null && !String.valueOf(id).isBlank() == true) {
				com.mydemo.DTO.Servico servico = new com.mydemo.DTO.Servico();
				servico = servicoRepo.findById(id).get();
				return servico;
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getCause());
		}

		return null;
	}
	
	
	@PostMapping(value="/v1/api/servico/add", produces = MediaType.APPLICATION_JSON_VALUE)

	@GetMapping(value = "/v1/api/servico/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CacheEvict(allEntries = true)
	@Transactional
	public List<Servico> listAllServicos() throws Exception {
		try {
			logger.debug("Trying to retrieve values from serviço Entity");
			if (!servicoRepo.findAll().isEmpty() == true) {
				List<Servico> lista = servicoRepo.findAll();
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
