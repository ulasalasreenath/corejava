package com.speakingcs.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.speakingcs.hibernate.entities.Employee;

public class HibernateTest {
	
	public static void main(String[] args)
	{
		Configuration configuration = new Configuration().configure("\\resources\\hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		
		/*Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp1 = new Employee();
		emp1.setName("sreenath");
		
		Employee emp2 = new Employee();
		emp2.setName("speakingcs");
		
		Employee emp3 = new Employee();
		emp3.setName("lenovo");
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		
		tx.commit();
		
		session.close();*/
		
		Session session = sf.openSession();
		Employee emp1 = (Employee) session.get(Employee.class, 1L);
		System.out.println(emp1.toString());
		
		Employee emp2 = (Employee) session.load(Employee.class, 1L);
		System.out.println(emp2.toString());

		Criteria criteria = session.createCriteria(Employee.class);
		
		criteria.add(Restrictions.gt("salary", 3000));
		
		List<Employee> employees = criteria.list();
		for(Employee emp: employees)
			System.out.println(emp.toString());
		
		session.close();
		sf.close();
		
		
		
		
	}
}
