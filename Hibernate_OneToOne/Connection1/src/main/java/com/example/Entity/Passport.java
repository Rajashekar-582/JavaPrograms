package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="passport_id")
	 private int id;
	 @Column(name="Passport_no")
	 private String passport_no;
	
	 @OneToOne
	 @JoinColumn(name = "pid")
	 private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassport_no() {
		return passport_no;
	}

	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Passport(int id, String passport_no, Person person) {
		super();
		this.id = id;
		this.passport_no = passport_no;
		this.person = person;
	}

	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
}
