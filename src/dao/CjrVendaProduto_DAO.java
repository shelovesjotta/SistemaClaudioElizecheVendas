/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CjrVenda;
import tools.HibernateUtil;
import bean.CjrVendaProduto;
import tools.Util;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER
 */
public class CjrVendaProduto_DAO extends DAO_Abstract{
    
    public List listProduto(CjrVenda cjrVenda) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrVendaProduto.class);
        criteria.add(Restrictions.eq("cjrVenda", cjrVenda));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

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
        Criteria criteria = session.createCriteria(CjrVendaProduto.class); // representa select * from usuarios só que no sistema orientado objeto
        criteria.add(Restrictions.eq("cjrIdVendaProduto", id)); //representa  usuarios só where id só que no sistema orientado objeto
        List lista = criteria.list();
        session.getTransaction().commit();
        return null;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrVendaProduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
   

}
