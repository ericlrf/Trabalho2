package dsc.trabalho2.beans;

import dsc.trabalho2.JsfUtil;
import dsc.trabalho2.entidades.Expositor;
import dsc.trabalho2.entidades.Palestrante;
import dsc.trabalho2.transacoes.ExpositorService;
import dsc.trabalho2.transacoes.PalestranteService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "palestranteBean")
@ViewScoped
public class PalestranteBean {

    private Palestrante palestrante;
    @EJB(name = "palestranteService")
    private PalestranteService palestranteService;

    /**
     * Creates a new instance of AutorBean
     */
    public PalestranteBean() {
        iniciarCampos();
    }

    public Palestrante getPalestrante() {
        return this.palestrante;
    }

    public void salvar() {
        palestranteService.salvar(palestrante);
        iniciarCampos();
        JsfUtil.adicionarMessagem("Cadastro do Palestrante realizado com sucesso!");
    }

    private void iniciarCampos() {
        this.palestrante = new Palestrante();
    }
}
