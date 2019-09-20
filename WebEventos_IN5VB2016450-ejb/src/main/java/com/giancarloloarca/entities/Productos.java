/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giancarloloarca.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author programacion
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdproductos", query = "SELECT p FROM Productos p WHERE p.idproductos = :idproductos")
    , @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "Productos.findByFechavencimiento", query = "SELECT p FROM Productos p WHERE p.fechavencimiento = :fechavencimiento")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductos")
    private Integer idproductos;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "precioVenta")
    private String precioVenta;
    @Size(max = 45)
    @Column(name = "fechavencimiento")
    private String fechavencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosIdproductos")
    private List<Detallefacturacion> detallefacturacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosIdproductos")
    private List<Detallecotizacion> detallecotizacionList;
    @JoinColumn(name = "tipoproducto_idtipoproducto", referencedColumnName = "idtipoproducto")
    @ManyToOne(optional = false)
    private Tipoproducto tipoproductoIdtipoproducto;

    public Productos() {
    }

    public Productos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    public Integer getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    @XmlTransient
    public List<Detallefacturacion> getDetallefacturacionList() {
        return detallefacturacionList;
    }

    public void setDetallefacturacionList(List<Detallefacturacion> detallefacturacionList) {
        this.detallefacturacionList = detallefacturacionList;
    }

    @XmlTransient
    public List<Detallecotizacion> getDetallecotizacionList() {
        return detallecotizacionList;
    }

    public void setDetallecotizacionList(List<Detallecotizacion> detallecotizacionList) {
        this.detallecotizacionList = detallecotizacionList;
    }

    public Tipoproducto getTipoproductoIdtipoproducto() {
        return tipoproductoIdtipoproducto;
    }

    public void setTipoproductoIdtipoproducto(Tipoproducto tipoproductoIdtipoproducto) {
        this.tipoproductoIdtipoproducto = tipoproductoIdtipoproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductos != null ? idproductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idproductos == null && other.idproductos != null) || (this.idproductos != null && !this.idproductos.equals(other.idproductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.giancarloloarca.entities.Productos[ idproductos=" + idproductos + " ]";
    }
    
}
