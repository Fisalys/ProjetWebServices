package fr.insa.projet.ressources;

import fr.insa.projet.dto.CompteDTO;
import fr.insa.projet.exeptions.ProcessExeption;
import fr.insa.projet.services.CommonService;
import fr.insa.projet.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("comptes")
public class CompteRessource extends CommonService {
    @Autowired
    CompteService compteService;

    @PostMapping
    public CompteDTO createCompte(@RequestBody CompteDTO compteDTO) throws ProcessExeption {
        compteService.validateCompteModel(compteDTO);
        return compteService.saveCompte(compteDTO);
    }

    @GetMapping("solde/{id}")
    public Integer getSolde(@PathVariable("id") Integer id) throws ProcessExeption {
        return compteService.getSoldeByCompte(id);
    }


}
