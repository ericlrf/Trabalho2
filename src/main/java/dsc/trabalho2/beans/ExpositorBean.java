package dsc.trabalho2.beans;

import dsc.trabalho2.JsfUtil;
import dsc.trabalho2.entidades.Expositor;
import dsc.trabalho2.transacoes.ExpositorService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "expositorBean")
@ViewScoped
public class ExpositorBean {

    private Expositor expositor;
    @EJB(name = "expositorService")
    private ExpositorService expositorService;

    /**
     * Creates a new instance of AutorBean
     */
    public ExpositorBean() {
        iniciarCampos();
    }

    public Expositor getExpositor() {
        return this.expositor;
    }

    public void salvar() {
        expositorService.salvar(expositor);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do expositor realizado com sucesso!");
    }

    private void iniciarCampos() {
        this.expositor = new Expositor();
    }
}
