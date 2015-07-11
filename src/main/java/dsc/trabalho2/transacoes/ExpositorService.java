package dsc.trabalho2.transacoes;

import dsc.trabalho2.dao.UsuarioDao;
import dsc.trabalho2.entidades.Expositor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless(name = "expositorService")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ExpositorService {

    @EJB
    private UsuarioDao dao;

    public void salvar(Expositor expositor) {
        dao.salvar(expositor);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Expositor> getAutores() {
        return (List<Expositor>) dao.get("Expositores");
    }
}
