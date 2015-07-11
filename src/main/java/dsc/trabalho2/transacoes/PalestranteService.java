package dsc.trabalho2.transacoes;

import dsc.trabalho2.dao.UsuarioDao;
import dsc.trabalho2.entidades.Expositor;
import dsc.trabalho2.entidades.Palestrante;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless(name = "palestranteService")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PalestranteService {

    @EJB
    private UsuarioDao dao;

    public void salvar(Palestrante palestrante) {
        dao.salvar(palestrante);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Palestrante> getPalestrantes() {
        return (List<Palestrante>) dao.get("Palestrantes");
    }
}
