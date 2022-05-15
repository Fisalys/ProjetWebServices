package fr.insa.projet.ressources;

import fr.insa.projet.dto.TransactionDTO;
import fr.insa.projet.exeptions.ProcessExeption;
import fr.insa.projet.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("transaction")
public class TransactionRessource {

    @Autowired
    TransactionService transactionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) throws ProcessExeption {
        transactionService.validateTransactionModel(transactionDTO);
        return transactionService.createTransaction(transactionDTO);
    }
}
