package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.ws.exception.AutorizationException;

@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "itens") // substituindo pela tag return que envelopa cada item
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) { // @WebParam substitui o args no soap
		System.out.println("Chamando getItens()");
		List<Filtro> lista = filtros.getLista();
		ArrayList<Item> todosItens = dao.todosItens(lista);
		return new ListaItens(todosItens);
	}

	@WebMethod(operationName = "cadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "token", header = true) TokenUsuario tokenUsuario,
			@WebParam(name = "item") Item item) throws AutorizationException {

		System.out.println("Cadastrando: " + item);
		boolean ehValido = new TokenDao().ehValido(tokenUsuario);
		if (!ehValido) {
			throw new AutorizationException("Token inválido");
		}

		dao.cadastrar(item);
		return item;
	}

	@Oneway // esse método é de mão única, não devolve resposta
	@WebMethod(operationName = "GerarRelatorio")
	public void gerarRelatorio() {
		System.out.println("Gerando relatório");
	}

//    <ns2:todosOsItensResponse xmlns:ns2="http://ws.estoque.caelum.com.br/">
//       <itens>
//          <item>
//             <codigo>SEO</codigo>
//             <nome>SEO na PrÃ¡tica</nome>
//             <quantidade>4</quantidade>
//             <tipo>Livro</tipo>
//          </item>
//      </itens>

//	<soapenv>
//	   <soapenv:Header/>
//	   <soapenv:Body>
//	      <ws:todosOsItens> //operation
//	         <filtros>
//	            <filtro>
//	               <nome>?</nome>
//	               <tipo>?</tipo>
//	            </filtro>
//	         </filtros>
//	      </ws:todosOsItens>
//	   </soapenv:Body>
//	</soapenv:Envelope>

//	@WebMethod(operationName = "todosOsItens")
//	@ResponseWrapper(localName = "itens")
//	@WebResult(name = "itens")
//	public List<Item> getAllItens(@WebParam(name = "filtros") Filtros filtros) {
//		return dao.todosItens();
//	}
}