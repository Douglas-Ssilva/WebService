package br.com.caelum.estoque.ws.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "AuthorizationFault")
public class AutorizationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorizationException(String msg) {
		super(msg);
	}

	public String getInfoException() {
		return "Authorization denied";
	}

//    <S:Fault xmlns:ns4="http://www.w3.org/2003/05/soap-envelope">
//	    <faultcode>S:Server</faultcode>
//	    <faultstring>Token inválido</faultstring>
//	    <detail>
//	       <ns2:AuthorizationFault xmlns:ns2="http://ws.estoque.caelum.com.br/">
//	          <infoException>Authorization denied</infoException>
//	          <message>Token inválido</message>
//	       </ns2:AuthorizationFault>
//	    </detail>
//    </S:Fault>

}
