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
@DiscriminatorValue("Heater")
public class Heater extends Device {
	
	private String nameHeater;
	private Integer power;
	private Home home;
	
	public Heater() {
		super();
	}
	public Heater(String name, Integer power, Home home) {
		super();
		this.nameHeater = name;
		this.power = power;
		this.home = home;
	}
	public String getNameHeater() {
		return nameHeater;
	}
	public void setNameHeater(String nameHeater) {
		this.nameHeater = nameHeater;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	@ManyToOne
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
	
}
