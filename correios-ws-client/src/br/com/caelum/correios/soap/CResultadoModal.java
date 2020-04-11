
package br.com.caelum.correios.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cResultadoModal complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cResultadoModal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServicosModal" type="{http://tempuri.org/}ArrayOfCModal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cResultadoModal", propOrder = {
    "servicosModal"
})
public class CResultadoModal {

    @XmlElement(name = "ServicosModal")
    protected ArrayOfCModal servicosModal;

    /**
     * Obtém o valor da propriedade servicosModal.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCModal }
     *     
     */
    public ArrayOfCModal getServicosModal() {
        return servicosModal;
    }

    /**
     * Define o valor da propriedade servicosModal.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCModal }
     *     
     */
    public void setServicosModal(ArrayOfCModal value) {
        this.servicosModal = value;
    }

}
