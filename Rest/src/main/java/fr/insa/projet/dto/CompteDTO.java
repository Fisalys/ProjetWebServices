package fr.insa.projet.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class CompteDTO implements Serializable {
    private Integer id;
    private String numero;
    private boolean decouvert;
    private int solde;
}
