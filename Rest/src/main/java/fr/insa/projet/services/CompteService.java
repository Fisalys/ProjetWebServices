package fr.insa.projet.services;

import fr.insa.projet.dto.CompteDTO;
import fr.insa.projet.exeptions.NotValidExeption;
import fr.insa.projet.exeptions.ProcessExeption;
import fr.insa.projet.models.Compte;
import fr.insa.projet.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompteService extends CommonService {
    @Autowired
    CompteRepository compteRepository;

    private static final String COMPTE_NOT_FOUND = "Compte non trouvée avec l'id : %s";

    public Compte getCompteById(Integer id) throws ProcessExeption {
        Compte compte = compteRepository.findById(id).orElseThrow(()-> new ProcessExeption(String.format(COMPTE_NOT_FOUND, id)));
        return compte;
    }

    public Compte getCompteByNumero(String numero) throws ProcessExeption
    {
        Compte compte = compteRepository.findCompteByNumero(numero);
        if(compte == null)
            throw new ProcessExeption(String.format(COMPTE_NOT_FOUND, numero));
        return compte;
    }

    public int getSoldeByCompte(Integer id) throws ProcessExeption {
        Compte compte = getCompteById(id);
        return compte.getSolde();
    }

    public CompteDTO saveCompte(CompteDTO CompteToCreate) throws ProcessExeption {
        Compte c = Compte.builder()
                .solde(CompteToCreate.getSolde())
                .numero(CompteToCreate.getNumero())
                .decouvert(false)
                .build();
        this.compteRepository.save(c);
        CompteToCreate.setId(c.getId());

        return CompteToCreate;
    }

    // permet de modifier le solde d'un compte
    public CompteDTO modifierCompte(CompteDTO compteDTO) throws ProcessExeption {
        Compte compte = compteRepository.findCompteByNumero(compteDTO.getNumero());
        compte.setSolde(compteDTO.getSolde());
        compteRepository.save(compte);
        return compteDTO;
    }

    public void validateCompteModel(CompteDTO compteToCreate) throws NotValidExeption
    {
        NotValidExeption e = new NotValidExeption();
        if(compteToCreate == null) e.getMessages().add("CompteModel : Null");
        else
        {   if(compteToCreate.getSolde() < 0) e.getMessages().add("solde incorrect");
        }
        if(!e.getMessages().isEmpty()) throw e;

    }
}

