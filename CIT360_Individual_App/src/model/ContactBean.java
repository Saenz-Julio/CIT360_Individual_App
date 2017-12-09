package model;

import java.io.Serializable;

/*JavaBeans is a regular java class.  It is not a specific object or program.
 * It must meet the following rules:
 * 1 - All properties set to private
 * 2 - Getters and setters methods (mutator methods)
 * 3 - Must have a public no argument constructor
 * 4 - Implement Serializable interface
*/

public class ContactBean implements Serializable {
	
	private long id;
	private String firstName;  // contact first name
	private String lastName;   // contact last name
	private String email;     // contact email
	private String phone;    // contact phone
	private String address;    // contact address
	private String company;    // contact company
	
	public ContactBean() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 * @param address
	 * @param company
	 */
	public ContactBean(long id, String firstName, String lastName, String email, String phone, String address, String company) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.company = company;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the startYear to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the payRate to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

}
