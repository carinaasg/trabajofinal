/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 *
 * @author casanchez
 */
@Entity
public class Pedido implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPedido;

     
    @ManyToMany
    @JoinTable(name="Pedido_Receta",joinColumns = @JoinColumn(name = "ID_PEDIDO"),inverseJoinColumns = @JoinColumn(name= "ID_RECETA"))
    private List<Receta> recetasPedidas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public List<Receta> getRecetas() {
        return recetasPedidas;
    }

    public void setRecetas(List<Receta> recetasPedidas) {
        this.recetasPedidas = recetasPedidas;
    }
            
    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
    private String direccionEnvio;   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frsf.ofa.cursojava.tp.integrador.modelo.Pedido[ id=" + id + " ]";
    }
    
    
}