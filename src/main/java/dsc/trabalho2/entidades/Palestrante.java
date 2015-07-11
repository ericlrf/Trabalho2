package dsc.trabalho2.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_PALESTRANTE") 
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID")
public class Palestrante extends Usuario implements Serializable {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ID_CONTA_BANCARIA", referencedColumnName = "ID")
    private ContaBancaria contaBancaria;

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
        this.contaBancaria.setDono(this);
    }
    
    @Override
    public String toString() {
        return "Palestrante[ id=" + id + " ]";
    }    
}
