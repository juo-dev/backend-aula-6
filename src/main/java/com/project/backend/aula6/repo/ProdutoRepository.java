package com.project.backend.aula6.repo;

import com.project.backend.aula6.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
