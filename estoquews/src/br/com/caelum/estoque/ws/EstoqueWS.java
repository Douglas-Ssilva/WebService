package br.com.caelum.estoque.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosOsItens") // <operation name="getItens"> fica no wsdl, tag wrapper no soapUI
	@WebResult(name = "itens") // substituindo pela tag return que envelopa cada iten
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) { // @WebParam substitui o args no soap
		System.out.println("Chamando getItens()");
		return new ListaItens(dao.todosItens());
	}

//	@WebMethod(operationName = "todosOsItens") // <operation name="getItens"> fica no wsdl, tag wrapper no soapUI
//	@ResponseWrapper(localName = "itens")
//	@WebResult(name = "itens") // substituindo pela tag return que envelopa cada iten
//	public List<Item> getAllItens(@WebParam(name = "filtros") Filtros filtros) { // @WebParam substitui o args no soap
//		System.out.println("Chamando getItens()");
//		return dao.todosItens();
//	}
}