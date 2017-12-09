package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import qcjson.*;
import model.ContactBean;

public class JSONApp {

	public static void main(String[] args) {

		ContactBean contact = new ContactBean(1, "Steve", "Smith", "test@test.com", "000-000-0000", "123 Street", "Tech Corp.");		
		File contactFile = new File("contactFile.json");
		
		try {
			
			// adds return from utility to variable and prints to console
			String jsonString = JSONUtilities.stringify(contact);
			System.out.printf("<--Java object converted to json and written to contactFile and Console:-->%n");	
			System.out.println(jsonString);		
			
			// creates file and adds return from JSON helper to variable and prints to file
			FileOutputStream fileStream = new FileOutputStream(contactFile);
			JSONOutputStream jsonOut = new JSONOutputStream(fileStream);
			jsonOut.writeObject(contact);
			jsonOut.close();	
			
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			// reads from file
			FileInputStream fileStream = new FileInputStream(contactFile);
			JSONInputStream jsonIn = new JSONInputStream(fileStream);
			
			HashMap jsonMap = (HashMap)jsonIn.readObject();
			jsonIn.close();
			
			Configuration cfg = new Configuration();
			cfg.configure("Hibernate.cfg.xml");

			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			
			ContactBean contactIn = new ContactBean();
			contactIn.setId((long)jsonMap.get("id"));
			contactIn.setFirstName((String)jsonMap.get("firstName"));
			contactIn.setLastName((String)jsonMap.get("lastName"));
			contactIn.setEmail((String)jsonMap.get("email"));
			contactIn.setPhone((String)jsonMap.get("phone"));
			contactIn.setAddress((String)jsonMap.get("address"));
			contactIn.setCompany((String)jsonMap.get("company"));
			
			Transaction tx = session.beginTransaction();
			session.save(contactIn);
			System.out.println("Object saved successfully.....!!");
			tx.commit();
			session.close();
			factory.close();
			
			String jsonString = JSONUtilities.stringify(contactIn);
			System.out.printf("%n<--This is the JSON string in the contactFile:-->");	
			System.out.printf("%n" + jsonString + "%n");	
			System.out.printf("%n<--JSON string converted back to java from the contactFile and values are added to ContactBean java object:-->");	
			System.out.printf("%n" + contactIn.getId() + contactIn.getFirstName() + " " + contactIn.getLastName() + " " + contactIn.getEmail() + " " + contactIn.getPhone() + " " + contactIn.getAddress() + " " + contactIn.getCompany() + "%n");

			
		} catch (JSONException | IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}

}
