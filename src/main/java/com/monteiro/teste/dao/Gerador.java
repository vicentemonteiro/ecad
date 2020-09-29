package com.monteiro.teste.dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monteiro.teste.model.ArquivoBancario;

@Component
public class Gerador {

	@Autowired
	ArquivoBancarioDAO dao;

	@PostConstruct
	public void criarExemplos() {
		final ArquivoBancario b1 = new ArquivoBancario();
		b1.setArquivo("arquivo_tr2.bla");
		b1.setAutor("Miguel");
		b1.setBanco("Santander");
		b1.setBoleto("48985634");
		b1.setEnvio(new Date());
		b1.setGeracao(new Date());
		b1.setNossoNumero("4898765");
		b1.setTipo("TR");
		b1.setUrl("http://site.com/sistema/arquivo_tr2.bla");
		b1.setTotal(new BigDecimal(800L));

		dao.save(b1);

		final ArquivoBancario b2 = new ArquivoBancario();
		b2.setArquivo("arquivo_tx1.bla");
		b2.setAutor("Rodrigo");
		b2.setBanco("Bradesco");
		b2.setBoleto("78815698");
		b2.setEnvio(new Date());
		b2.setGeracao(new Date());
		b2.setNossoNumero("7847899");
		b2.setTipo("TX");
		b2.setUrl("http://site.com/sistema/arquivo_tx1.bla");
		b2.setTotal(new BigDecimal(500L));

		dao.save(b2);
	}
}
