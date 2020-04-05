package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Tem a responsabilidade de embrulhar a interface List somente
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) // JAX-B segue os get e set p acessar atributos, por isso essa configuração
public class ListaItens {

	@XmlElement(name = "item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	public ListaItens() {
	}

	public List<Item> getItens() {
		return itens;
	}

}
