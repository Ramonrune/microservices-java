package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraServiceOld {
	
	@Autowired
	private RestTemplate client;

	@Autowired
	private DiscoveryClient eurekaClient;
	
	public void realizaCompra(CompraDTO compra) {
		
	
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
				InfoFornecedorDTO.class);
		
		eurekaClient.getInstances("fornecedor").stream().forEach(e -> {
			System.out.println("localhost:" + e.getPort());
		});
		 

		System.out.println(exchange.getBody().getEndereco());

	}

}
