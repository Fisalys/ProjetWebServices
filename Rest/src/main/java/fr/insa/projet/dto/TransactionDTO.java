package fr.insa.projet.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder
public class TransactionDTO implements Serializable {
    private Date date;
    private Integer benefId;
    private Integer emettId;
    private float montant;
}
