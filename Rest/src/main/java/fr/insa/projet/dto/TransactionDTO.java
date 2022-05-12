package fr.insa.projet.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO implements Serializable {
    private Integer id;
    private Date date;
    private Integer benefId;
    private Integer emettId;
    private int montant;
}
