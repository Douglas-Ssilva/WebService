package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {

	public static void main(String[] args) {

		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("EstoqueWS rodando: " + URL);

		// class que public o servi�o. Associando URL com implementacao
		Endpoint.publish(URL, implementacaoWS);
//		http://localhost:8080/estoquews?wsdl defini��es do nosso web service, descreve o que pode e o que n�o pode no meu service
	}

}