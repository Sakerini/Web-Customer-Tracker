package com.sakerini.webcustomertracker.dao;

import com.sakerini.webcustomertracker.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> theQuery =
                session.createQuery("from Customer order by firstName");

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();

        Customer theCustomer = session.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        /*
        Customer theCustomer = session.get(Customer.class, theId);

        session.delete(theCustomer);
         */

        Query theQuery =
                session.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomer(String theSearchName) {

        Session session = sessionFactory.getCurrentSession();
        Query theQuery = null;

        if (theSearchName != null && theSearchName.trim().length() > 0) {

            theQuery = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName)" +
                    "like :theName", Customer.class);

            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            theQuery = session.createQuery("from Customer ", Customer.class);
        }

        List<Customer> customers = theQuery.getResultList();

        return customers;

    }
}
