package com.mydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mydemo.DTO.Cliente;
import com.mydemo.DTO.Servico;

public interface ClienteRepository extends JpaRepository<com.mydemo.DTO.Cliente, Long> {
	
	@Query(name = "findByServico", nativeQuery = true, value="SELECT * from CLiente c "
			+ "right join servico s "
			+ "on s.cliente_id = c.id")
	
	Cliente findByServicoId(Servico servico);

}
