/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giancarloloarca.sessionsbeans;

import com.giancarloloarca.entities.Facturacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author programacion
 */
@Stateless
public class FacturacionFacade extends AbstractFacade<Facturacion> implements FacturacionFacadeLocal {

    @PersistenceContext(unitName = "com.giancarloloarca_WebEventos_IN5VB2016450-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturacionFacade() {
        super(Facturacion.class);
    }
    
}
