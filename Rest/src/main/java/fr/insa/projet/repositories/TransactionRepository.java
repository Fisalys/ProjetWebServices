package fr.insa.projet.repositories;

import fr.insa.projet.models.Compte;
import fr.insa.projet.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findTransactionsByCbenefOrCemett(Compte cbenef, Compte cemett);
}
