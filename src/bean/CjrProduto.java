package bean;
// Generated 14/09/2023 13:54:22 by Hibernate Tools 4.3.1



import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CjrProduto generated by hbm2java
 */
@Entity
@Table(name="cjr_produto"
    ,catalog="db_claudio_elizeche"
)
public class CjrProduto  implements java.io.Serializable {


     private int cjrIdProduto;
     private String cjrNome;
     private String cjrDescricao;
     private String cjrPreco;
     private int cjrQuantidade;
     private String cjrTipo;
     

    public CjrProduto() {
    }

	
    public CjrProduto(String cjrNome, String cjrDescricao, String cjrPreco, int cjrQuantidade, String cjrTipo) {
        this.cjrNome = cjrNome;
        this.cjrDescricao = cjrDescricao;
        this.cjrPreco = cjrPreco;
        this.cjrQuantidade = cjrQuantidade;
        this.cjrTipo = cjrTipo;
    }
  
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cjr_idProduto", unique=true, nullable=false)
    public int getCjrIdProduto() {
        return this.cjrIdProduto;
    }
    
    public void setCjrIdProduto(int cjrIdProduto) {
        this.cjrIdProduto = cjrIdProduto;
    }
    
    @Column(name="cjr_nome", nullable=false, length=45)
    public String getCjrNome() {
        return this.cjrNome;
    }
    
    public void setCjrNome(String cjrNome) {
        this.cjrNome = cjrNome;
    }

    
    @Column(name="cjr_descricao", nullable=false, length=100)
    public String getCjrDescricao() {
        return this.cjrDescricao;
    }
    
    public void setCjrDescricao(String cjrDescricao) {
        this.cjrDescricao = cjrDescricao;
    }

    
    @Column(name="cjr_preco", nullable=false, precision=9)
    public String getCjrPreco() {
        return this.cjrPreco;
    }
    
    public void setCjrPreco(String cjrPreco) {
        this.cjrPreco = cjrPreco;
    }

    
    @Column(name="cjr_quantidade", nullable=false)
    public int getCjrQuantidade() {
        return this.cjrQuantidade;
    }
    
    public void setCjrQuantidade(int cjrQuantidade) {
        this.cjrQuantidade = cjrQuantidade;
    }

    
    @Column(name="cjr_tipo", nullable=false, length=100)
    public String getCjrTipo() {
        return this.cjrTipo;
    }
    
    public void setCjrTipo(String cjrTipo) {
        this.cjrTipo = cjrTipo;
    }
}

