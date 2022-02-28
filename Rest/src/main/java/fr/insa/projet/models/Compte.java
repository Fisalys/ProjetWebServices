package fr.insa.projet.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private int solde;
    private boolean decouvert;
    @OneToMany(mappedBy = "cbenef")
    private List<Transaction> transactionsBenef;
    @OneToMany(mappedBy = "cemett")
    private List<Transaction> transactionsEmett;
}
