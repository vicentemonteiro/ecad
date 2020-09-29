package com.monteiro.teste.controller;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.monteiro.teste.dao.ArquivoBancarioDAO;
import com.monteiro.teste.model.ArquivoBancario;

/**
 *
 * @author vicente.monteiro
 */
@RestController
@RequestMapping("privada/arquivo_bancario")
public class ArquivoBancarioController {

    @Autowired
    ArquivoBancarioDAO dao;

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public Collection<ArquivoBancario> filter(final String banco, final String nossoNumero, final String tipo, final String boleto, final Date inicio, final Date fim) {
        return IteratorUtils.toList(this.dao.recuperarFiltrado(banco, boleto, nossoNumero, tipo).iterator());
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Collection<ArquivoBancario> all() {
        return IteratorUtils.toList(this.dao.findAll().iterator());
    }
  
}
