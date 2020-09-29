package com.monteiro.teste.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.monteiro.teste.model.ArquivoBancario;

/**
 *
 * @author vicente.monteiro
 */
public interface ArquivoBancarioDAO extends CrudRepository<ArquivoBancario, Long> {

	@Query("SELECT s FROM ArquivoBancario s WHERE " + "(s.banco = :banco OR :banco IS NULL) "
			+ "AND (s.boleto = :boleto or :boleto IS NULL) "
			+ "AND (s.nossoNumero = :nossoNumero OR :nossoNumero IS NULL) " + "AND (s.tipo = :tipo OR :tipo IS NULL)")
	List<ArquivoBancario> recuperarFiltrado(String banco, String boleto, String nossoNumero, String tipo);
}
