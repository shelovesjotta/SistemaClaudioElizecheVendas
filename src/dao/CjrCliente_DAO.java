/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import tools.HibernateUtil;
import bean.CjrCliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER
 */
public class CjrCliente_DAO extends DAO_Abstract {

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
        Criteria criteria = session.createCriteria(CjrCliente.class);
        criteria.add(Restrictions.eq("cjrIdCliente", id));
        Object cliente = criteria.uniqueResult(); //UniqueResult() para buscar um único resultado
        session.getTransaction().commit();
        return cliente;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrCliente.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrCliente.class);
        criteria.add(Restrictions.like("cjrNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listSal(double saldo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrCliente.class);
        criteria.add(Restrictions.ge("cjrSaldoCarteira", saldo)); 
        criteria.add(Restrictions.le("cjrSaldoCarteira", saldo)); 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listNomeSal(String nome, double saldo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CjrCliente.class);
        criteria.add(Restrictions.like("cjrNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("cjrSaldoCarteira", saldo)); 
        criteria.add(Restrictions.le("cjrSaldoCarteira", saldo));  
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public static void main(String[] args) {
        
    
        CjrCliente_DAO cjrUsuarios_DAO = new CjrCliente_DAO();
        List lista = cjrUsuarios_DAO.listAll();
        
        
        for (Object object : lista) {
            System.out.println(((CjrCliente)object).getCjrNome());
        }
        System.out.println("fim");
    }
    
}
