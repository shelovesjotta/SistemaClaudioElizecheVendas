/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CjrCliente;
import tools.HibernateUtil;
import bean.CjrUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        Criteria criteria = session.createCriteria(CjrUsuarios.class); // representa select * from usuarios só que no sistema orientado objeto
        criteria.add(Restrictions.eq("cjrIdUsuario", id)); //representa  usuarios só where id só que no sistema orientado objeto
        List lista = criteria.list();
        session.getTransaction().commit();
        return null;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object buscarLogin(String apelido, String senha) {
        CjrUsuarios cjrusuarios = null;

        String url = "jdbc:mysql://10.7.0.51:33062/db_claudio_elizeche";
        String user = "claudio_elizeche";
        String password = "claudio_elizeche";

        //String url = "jdbc:mysql://127.0.0.1:3306/db_claudio_elizeche";
        //String user = "root";
        //String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM usuarios WHERE apelido = ? AND senha = ?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
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
    
}
