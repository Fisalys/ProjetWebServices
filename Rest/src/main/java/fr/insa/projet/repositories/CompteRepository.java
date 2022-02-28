package fr.insa.projet.repositories;

import fr.insa.projet.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Compte findCompteByNumero(String numero);
}
