package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoForncedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate restTemplate;

	public void realizaCompra(CompraDTO compra) {
		ResponseEntity<InfoForncedorDTO> exchange = restTemplate.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), HttpMethod.GET, null, InfoForncedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
