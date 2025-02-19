package com.consumption.crud.repositories;

import com.consumption.crud.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer > {
}
