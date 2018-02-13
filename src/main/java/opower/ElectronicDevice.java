package opower;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ElectronicDevice")
public class ElectronicDevice extends Device {
	
	private Integer consumption;
	private Person person;
	
	public ElectronicDevice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElectronicDevice(Integer consumption) {
		super();
		this.consumption = consumption;
	}
	public Integer getConsumption() {
		return consumption;
	}
	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
