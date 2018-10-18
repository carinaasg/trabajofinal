/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Pedido;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Receta;

/**
 *
 * @author casanchez
 */
@Stateless
public class PedidoService {  
    
    @PersistenceContext(unitName = "RECETAS_PU")
    private EntityManager em;
    
   
    public Pedido guardar(Pedido r){        
        if(r.getId()!=null && r.getId()>0) {
                return em.merge(r);
        }
        em.persist(r);
        em.flush();
        em.refresh(r);
        return r;
    }  
 
        public List<Pedido> listar(){
        return em.createQuery("SELECT r FROM Pedido r").getResultList();
    }
    
    public List<Receta> recetasPorIdPedido(Integer id){
        return em.createQuery("SELECT i FROM Pedido r JOIN r.recetas i WHERE r.id = :P_ID_PEDIDO")
                .setParameter("P_ID_PEDIDO", id)
                .getResultList();
    }
    
        
}
