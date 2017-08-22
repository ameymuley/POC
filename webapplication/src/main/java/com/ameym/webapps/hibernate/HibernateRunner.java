package com.ameym.webapps.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ameym.webapps.config.HibernateConnector;
import com.ameym.webapps.model.User;

public class HibernateRunner {

	public static void main(String[] args) {
		
		/*User user = new User("sagarnikhade", "Sagar789", "Sagar", "Nikhade", "sagar@gmail.com", "9890548594");
		
		Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("Controller userID: " + user.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
		
		Map<String, User> users = new HashMap();
		
		Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("From User");
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                System.out.println("Inside if.. No output..");
            } else {
                System.out.println("list " + queryList);
                Iterator itr = queryList.iterator();
                while(itr.hasNext()) {
                	User user = (User) itr.next();
                	users.put(user.getUserName(), user);
                }
                
                for (Map.Entry<String, User> entry : users.entrySet()) {
                    String key = entry.getKey();
                    User value = entry.getValue();
                    
                    System.out.println(key + " =====>  " + "FirstName:-" + value.getFirstName() + " LastName:-" + value.getLastName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
	}

}
