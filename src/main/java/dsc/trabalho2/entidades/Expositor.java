package dsc.trabalho2.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_EXPOSITOR") 
@DiscriminatorValue(value = "E")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
public class Expositor extends Usuario implements Serializable {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ID_CARTAO_CREDITO", referencedColumnName = "ID")
    private CartaoCredito cartaoCredito;

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
        this.cartaoCredito.setDono(this);
    }

    @Override
    public String toString() {
        return "Expositor[ id=" + id + " ]";
    }

}
