package br.com.caelum.estoque.cliente;

import java.util.List;

public class MainEstoqueWSClient {

	public static void main(String[] args) {
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("Xiaomi");
		filtro.setTipo("Celular");
		filtros.getFiltro().add(filtro);

		EstoqueWS estoqueWSclient = new EstoqueWS_Service().getEstoqueWSPort();// Estabelece conexão tbm conhecido como proxy ou remote
		ListaItens todosOsItens = estoqueWSclient.todosOsItens(filtros);
		List<Item> item = todosOsItens.getItem();
		item.forEach(i -> System.out.println(i.getNome()));
	}

}
