package fr.insa.projet.services;

import fr.insa.projet.dto.CompteDTO;
import fr.insa.projet.dto.TransactionDTO;
import fr.insa.projet.exeptions.NotValidExeption;
import fr.insa.projet.exeptions.ProcessExeption;
import fr.insa.projet.models.Compte;
import fr.insa.projet.models.Transaction;
import fr.insa.projet.repositories.CompteRepository;
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
    @Autowired
    private CompteRepository compteRepository;

    public Transaction getTransactionById(Integer id) throws ProcessExeption
    {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(()-> new ProcessExeption(String.format(TRANSACTION_NOT_FOUND, id)));
        return transaction;
    }


    public void validateTransactionModel(TransactionDTO transactionDTO) throws NotValidExeption
    {
        NotValidExeption e = new NotValidExeption();
        if(transactionDTO == null)
            e.getMessages().add("CompteModel : Null");
        else{
            if(transactionDTO.getDate() == null) e.getMessages().add("data incorrect");
            if(transactionDTO.getBenefId() == null) e.getMessages().add("beneficiaire incorrect");
            if(transactionDTO.getEmettId() == null) e.getMessages().add("emetteur incorrect");
            if(transactionDTO.getMontant() <= 0) e.getMessages().add("emetteur incorrect");
        }
        if(!e.getMessages().isEmpty()) throw e;
    }

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) throws ProcessExeption {
        Compte emmet = compteService.getCompteById(transactionDTO.getEmettId());
        Compte benef = compteService.getCompteById(transactionDTO.getBenefId());

        Transaction t = Transaction.builder()
                .date(transactionDTO.getDate())
                .montant(transactionDTO.getMontant())
                .cemett(emmet)
                .cbenef(benef)
                .build();

        transactionRepository.save(t);
        transactionDTO.setId(t.getId());

        emmet.setSolde((emmet.getSolde()-transactionDTO.getMontant()));
        benef.setSolde((benef.getSolde()+transactionDTO.getMontant()));

        compteRepository.save(emmet);
        compteRepository.save(benef);

        return transactionDTO;
    }

}
