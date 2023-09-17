package bean;
// Generated 14/09/2023 13:54:22 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CjrUsuarios generated by hbm2java
 */

@Table(name="cjr_usuarios"
    ,catalog="db_claudio_elizeche"
)
public class CjrUsuarios  implements java.io.Serializable {


     private int cjrIdUsuario;
     private String cjrNome;
     private String cjrApelido;
     private String cjrCpf;
     private Date cjrDataNascimento;
     private String cjrSenha;
     private int cjrNivel;
     private String cjrAtivo;

    public CjrUsuarios() {
    }

	
    public CjrUsuarios(String cjrNome, String cjrApelido, String cjrCpf, Date cjrDataNascimento, String cjrSenha, int cjrNivel, String cjrAtivo) {
       this.cjrNome = cjrNome;
       this.cjrApelido = cjrApelido;
       this.cjrCpf = cjrCpf;
       this.cjrDataNascimento = cjrDataNascimento;
       this.cjrSenha = cjrSenha;
       this.cjrNivel = cjrNivel;
       this.cjrAtivo = cjrAtivo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cjr_idUsuario", unique=true, nullable=false)
    public int getCjrIdUsuario() {
        return this.cjrIdUsuario;
    }
    
    public void setCjrIdUsuario(int cjrIdUsuario) {
        this.cjrIdUsuario = cjrIdUsuario;
    }

    
    @Column(name="cjr_nome", nullable=false, length=60)
    public String getCjrNome() {
        return this.cjrNome;
    }
    
    public void setCjrNome(String cjrNome) {
        this.cjrNome = cjrNome;
    }

    
    @Column(name="cjr_apelido", nullable=false, length=25)
    public String getCjrApelido() {
        return this.cjrApelido;
    }
    
    public void setCjrApelido(String cjrApelido) {
        this.cjrApelido = cjrApelido;
    }

    
    @Column(name="cjr_cpf", nullable=false, length=14)
    public String getCjrCpf() {
        return this.cjrCpf;
    }
    
    public void setCjrCpf(String cjrCpf) {
        this.cjrCpf = cjrCpf;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="cjr_dataNascimento", length=10)
    public Date getCjrDataNascimento() {
        return this.cjrDataNascimento;
    }
    
    public void setCjrDataNascimento(Date cjrDataNascimento) {
        this.cjrDataNascimento = cjrDataNascimento;
    }

    
    @Column(name="cjr_senha", nullable=false, length=20)
    public String getCjrSenha() {
        return this.cjrSenha;
    }
    
    public void setCjrSenha(String cjrSenha) {
        this.cjrSenha = cjrSenha;
    }

    
    @Column(name="cjr_nivel", nullable=false)
    public int getCjrNivel() {
        return this.cjrNivel;
    }
    
    public void setCjrNivel(int cjrNivel) {
        this.cjrNivel = cjrNivel;
    }

    
    @Column(name="cjr_ativo", nullable=false, length=1)
    public String getCjrAtivo() {
        return this.cjrAtivo;
    }
    
    public void setCjrAtivo(String cjrAtivo) {
        this.cjrAtivo = cjrAtivo;
    }
}


