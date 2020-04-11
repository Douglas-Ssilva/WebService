package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {

	public static void main(String[] args) {

		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("EstoqueWS rodando: " + URL);

		// class que public o serviço. Associando URL com implementacao
		Endpoint.publish(URL, implementacaoWS);
//		http://localhost:8080/estoquews?wsdl definições do nosso web service, descreve o que pode e o que não pode no meu service
	}

}