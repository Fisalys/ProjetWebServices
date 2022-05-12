
package gateway;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transaction" type="{http://localhost:8081}transaction"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transaction"
})
@XmlRootElement(name = "getTransactionResponse", namespace = "http://localhost:8081")
public class GetTransactionResponse {

    @XmlElement(namespace = "http://localhost:8081", required = true)
    protected Transaction transaction;

    /**
     * Obtient la valeur de la propriété transaction.
     *
     * @return
     *     possible object is
     *     {@link Transaction }
     *
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Définit la valeur de la propriété transaction.
     *
     * @param value
     *     allowed object is
     *     {@link Transaction }
     *
     */
    public void setTransaction(Transaction value) {
        this.transaction = value;
    }

}
