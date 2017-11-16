package com.mycompany.Mini_projet;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Application class.
 *
 * @author Nafaa Friaa (nafaa.friaa@isetjb.rnu.tn)
 */
public class Application {

    /**
     * Attribute declaration for factory to share between methods.
     */
    private static SessionFactory factory;

    public static void main(String[] args) {
        System.out.println("JavaSE + Maven + Hibernate + MySQL : Many to One Association");

        // Open connection  pool
        factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            // new category
            Category category_a = new Category();
            category_a.setLibelle("Cat a");
            session.save(category_a);

            // new category
            Category category_b = new Category();
            category_b.setLibelle("Cat b");
            session.save(category_b);
             option option_a = new option();
            
            // new product
            Chambre Chambre_x = new Chambre();
            Chambre_x.setName("chamx");
            Chambre_x.setPrice(456);
            Chambre_x.setCategory(category_a);
            Chambre_x.setOption(option_a);
            session.save(Chambre_x);
            
           
            option_a.setName("opt b");
            option_a.setChambre(Chambre_x);
            session.save(category_b);
           
            Chambre Chambre_y = new Chambre();
            Chambre_y.setName("CHAMBRE y");
            Chambre_y.setPrice(123);
            Chambre_y.setCategory(category_b);
            Chambre_y.setOption(option_a);
            session.save(Chambre_y);
            
            Chambre Chambre_z = new Chambre();
            Chambre_z.setName("cham z");
            Chambre_z.setPrice(789);
            Chambre_z.setCategory(category_a);
            Chambre_z.setOption(option_a);
            session.save(Chambre_z);

            // product list by executing HQL Query
            List products = session.createQuery("FROM Chambre").list();

            for (Iterator iterator = products.iterator(); iterator.hasNext();)
            {
                Chambre Chambre = (Chambre) iterator.next();
                System.out.print("ID: " + Chambre.getId());
                System.out.print(" ===> NAME: " + Chambre.getName());
                System.out.print(" ===> PRICE: " + Chambre.getPrice());
                System.out.println(" ===> CATEGORY: " + Chambre.getCategory().getLibelle());
            }

            transaction.commit();
             
 // new client
            Client client_a = new Client();
            client_a.setName("clt b");
            client_a.setTelephone("2345554");
            client_a.setAdresse("TUNIS");
            session.save(client_a);

            // new client
            Client client_b = new Client();
            client_b.setName("clt b");
            client_b.setTelephone(" 345456");
            client_b.setAdresse("DJERBA");
            session.save(client_b);

            // new sejour
            Sejour sejour_x = new Sejour();
            
            sejour_x.setDate_debut(2/2/2017);
            sejour_x.setDate_fin(2/2/2017);
            sejour_x.setClient(client_a);
            session.save(sejour_x);

            // new sejour
            Sejour sejour_y = new Sejour();
            
            sejour_y.setDate_debut(23/3/2017);
            sejour_y.setDate_fin(23/4/2017);
            sejour_y.setClient(client_b);
            session.save(sejour_y);
            // new sejour
            Sejour sejour_z = new Sejour();
            
            sejour_z.setDate_debut(23/3/2017);
            sejour_z.setDate_fin(23/5/2017);
            sejour_z.setClient(client_a);
            session.save(sejour_z);

            List sejours = session.createQuery("FROM Sejour").list();

            for (Iterator iterator = sejours.iterator(); iterator.hasNext();)
            {
                Sejour sejour = (Sejour) iterator.next();
                System.out.print("ID: " + sejour.getId());
                System.out.print(" ===> getDate_debut: " + sejour.getDate_debut());
                System.out.print(" ===> date_fin: " + sejour.getDate_fin());
                System.out.println(" ===> client: " + sejour.getClient().getName());
            }

            transaction.commit();
        } 
           catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            //e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        } finally
        {
            session.close();
        }

        // Cleaning up connection pool
        factory.close();
    }

}
