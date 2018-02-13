package opower;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	private Integer id;
	private String name;
	private String surname;
	private String mail;
	private List<Home> homes = new ArrayList<Home>();
	private List<ElectronicDevice> electronicdevices = new ArrayList<ElectronicDevice>();
	private List<Friendship> friendships = new ArrayList<Friendship>();
	
	public Person() {
	}
	public Person(String name, String surname, String mail) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
	}
	public Person(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return mail;
	}
	public void setEmail(String mail) {
		this.mail = mail;
	}
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<Home> getHomes() {
		return homes;
	}
	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<ElectronicDevice> getElectronicdevices() {
		return electronicdevices;
	}
	public void setElectronicdevices(List<ElectronicDevice> electronicdevices) {
		this.electronicdevices = electronicdevices;
	}

	@Override
	public String toString() {
		return "a";
		//return "Employee [id=" + id + ", name=" + name + ", department="
		//		+ home.getName() + "]";
	}

}
