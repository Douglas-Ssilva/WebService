package br.com.caelum.estoque.teste;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.caelum.estoque.modelo.item.Item;

public class Teste {

	public static void main(String[] args) {
		// Lendo e escrevendo XML
		Item item = new Item.Builder().comCodigo("MEA").comNome("MEAN").comQuantidade(60).comTipo("Livro").build();
		System.out.println("Rodando");
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Item.class);

			Marshaller marshaller = context.createMarshaller();
			File file = new File("item.xml");
			marshaller.marshal(item, file);

			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			Item item2 = (Item) jaxbUnmarshaller.unmarshal(file);
			System.out.println(item2);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
