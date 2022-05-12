
package gateway;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour transaction complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="transaction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="benefId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="emettId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaction", namespace = "http://localhost:8081", propOrder = {
    "id",
    "date",
    "benefId",
    "emettId",
    "montant"
})
public class Transaction {

    @XmlElement(namespace = "http://localhost:8081")
    protected int id;
    @XmlElement(namespace = "http://localhost:8081", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(namespace = "http://localhost:8081")
    protected int benefId;
    @XmlElement(namespace = "http://localhost:8081")
    protected int emettId;
    @XmlElement(namespace = "http://localhost:8081")
    protected int montant;

    /**
     * Obtient la valeur de la propriété id.
     *
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     *
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété benefId.
     *
     */
    public int getBenefId() {
        return benefId;
    }

    /**
     * Définit la valeur de la propriété benefId.
     *
     */
    public void setBenefId(int value) {
        this.benefId = value;
    }

    /**
     * Obtient la valeur de la propriété emettId.
     *
     */
    public int getEmettId() {
        return emettId;
    }

    /**
     * Définit la valeur de la propriété emettId.
     *
     */
    public void setEmettId(int value) {
        this.emettId = value;
    }

    /**
     * Obtient la valeur de la propriété montant.
     *
     */
    public int getMontant() {
        return montant;
    }

    /**
     * Définit la valeur de la propriété montant.
     *
     */
    public void setMontant(int value) {
        this.montant = value;
    }

}
