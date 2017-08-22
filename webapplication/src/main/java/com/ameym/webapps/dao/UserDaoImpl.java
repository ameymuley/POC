package com.ameym.webapps.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ameym.webapps.config.HibernateConnector;
import com.ameym.webapps.model.User;


@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	private static Map<String, User> users = new HashMap();

	public Map<String, User> getUsers() {
		 Session session = null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            Query query = session.createQuery("From User");
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                Iterator itr = queryList.iterator();
	                while(itr.hasNext()) {
	                	User user = (User) itr.next();
	                	users.put(user.getUserName(), user);
	                }
	                return users;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	}

	public User getUser(String userName) {
		Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from appuser u where u.username = :username");
            query.setParameter("username", userName);
 
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (User) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
	}

	public Integer deleteUser(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer createUser(User user) {
		Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("Controller userID: " + user.getUserId());
            return user.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
	}

}
