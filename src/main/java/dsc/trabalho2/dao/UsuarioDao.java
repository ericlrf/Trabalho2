package dsc.trabalho2.dao;

import dsc.trabalho2.entidades.Usuario;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuarioDao {
    @PersistenceContext(name = "Trabalho2_PU", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }
    
    public List get(String nomeQuery) {
        Query query = entityManager.createNamedQuery(nomeQuery);
        return query.getResultList();
    }
    
    public List get(String nomeQuery, Object[] parametros) {
        Query query = entityManager.createNamedQuery(nomeQuery);
        
        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }
        
        return query.getResultList();        
    }
}
