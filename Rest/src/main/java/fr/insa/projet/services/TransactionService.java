package fr.insa.projet.services;

import fr.insa.projet.exeptions.ProcessExeption;
import fr.insa.projet.models.Transaction;
import fr.insa.projet.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends CommonService {
    private static final String TRANSACTION_NOT_FOUND = "Transaction non trouvée avec l'id : %s";

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CompteService compteService;

    public Transaction getTransactionById(Integer id) throws ProcessExeption
    {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()-> new ProcessExeption(String.format(TRANSACTION_NOT_FOUND, id)));
        return transaction;
    }
}
