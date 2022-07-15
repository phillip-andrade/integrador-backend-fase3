package br.com.icarros.icontas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.icarros.icontas.entity.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    public Optional<Gerente> findByCpf (String cpf);

}
