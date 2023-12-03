package com.br.readnow.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.readnow.api.model.LivroItemCarrinhoModel;
import com.br.readnow.api.model.LivroModel;
@Repository
public interface LivroItemCarrinhoRepository extends CrudRepository<LivroItemCarrinhoModel, Long>{
    boolean existsByCodigo(Long codigo);
    List<LivroItemCarrinhoModel> findAllByLivroCodigo(Long codigo);
    List<LivroItemCarrinhoModel> findAllByUsuarioId(Long usuarioId);
    List<LivroItemCarrinhoModel> findAllByCarrinhoCodigo(Long codigo);

}
