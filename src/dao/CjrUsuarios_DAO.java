/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CjrUsuarios;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER
 */
public class CjrUsuarios_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit(); // todos os movimentos no bd são feitos por transação
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush(); //Pra não enviar coisa erradas e limpar o cash
        session.clear(); //Pra não enviar coisa erradas e limpar o cash
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush(); //Pra não enviar coisa erradas e limpar o cash
        session.clear(); //Pra não enviar coisa erradas e limpar o cash
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrUsuarios.class);
        criteria.add(Restrictions.eq("cjrIdUsuario", id)); // Seria como o where do sql e o eq é um metodo estatico. ne é not equals.
        List lista = criteria.list(); //like é quando é parecido, por exemplo se tiver algum nome que começa com mar ele vai pesquisar por meio desse mar.
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrUsuarios.class); //basicamente é o select * from no hibernate.
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
     public List listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrUsuarios.class);
        criteria.add(Restrictions.like("cjrNome", "%"+nome+"%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
     
     }
     
     public List listCpf(String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrUsuarios.class);
        criteria.add(Restrictions.like("cjrCpf", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;

    }
     
    public List listNomeCpf(String nome, String cpf) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrUsuarios.class);
        criteria.add(Restrictions.like("cjrNome", "%" + nome + "%"));
        criteria.add(Restrictions.like("cjrCpf", "%" + cpf + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;

    }


    
    public Object buscarLogin(String apelido, String senha) {
        CjrUsuarios cjrusuarios = null;

        String url = "jdbc:mysql://10.7.0.51:33062/db_claudio_elizeche";
        String user = "claudio_elizeche";
        String password = "claudio_elizeche";

//        String url = "jdbc:mysql://127.0.0.1:3306/db_claudio_elizeche";
//        String user = "root";
//        String password = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt = (Connection) DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM cjr_usuarios WHERE cjr_apelido = ? AND cjr_senha = ?";
            PreparedStatement pstm = (PreparedStatement) cnt.prepareStatement(sql);
            pstm.setString(1, apelido);
            pstm.setString(2, senha);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                cjrusuarios = new CjrUsuarios();
                cjrusuarios.setCjrApelido(rs.getString("apelido"));
                cjrusuarios.setCjrSenha(rs.getString("senha"));
            }

            rs.close();
            pstm.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CjrUsuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CjrUsuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cjrusuarios;
    }
     
    public static void main(String[] args) {
        CjrUsuarios_DAO cjrUsuarios_DAO = new CjrUsuarios_DAO();
        List lista = cjrUsuarios_DAO.listAll();
        for (Object object : lista) {
            System.out.println(((CjrUsuarios)object).getCjrNome());
        }
        System.out.println("fim");
    }
}
