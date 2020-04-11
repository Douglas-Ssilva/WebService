package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class MainEstoqueWSOther {

	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("http://localhost:8080/estoquews-server/estoqueWS?wsdl");
		QName qname = new QName("http://ws.estoque.caelum.com.br/", "estoqueWS");

		Service service = Service.create(url, qname);

		EstoqueWS cliente = service.getPort(EstoqueWS.class);

		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("Xiaomi");
		filtro.setTipo("Celular");
		filtros.getFiltro().add(filtro);
		

		ListaItens lista = cliente.todosOsItens(filtros);

		for (Item item : lista.item) {
			System.out.println(item.getNome());
		}
	}

}
