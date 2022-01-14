package com.api.GestaoIgreja.repository;


import com.api.GestaoIgreja.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    List<Membro> findByCpf(long cpf);

}
