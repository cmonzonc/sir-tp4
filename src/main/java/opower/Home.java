package opower;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {
	
	private Integer id;
	private String name;
	private Person person;
	private Double size;
	private Integer pieces;
	
	private List<Heater> heaters = new ArrayList<Heater>();
	
	public Home() {
		super();
	}
	
	public Home(Double size, Integer pieces, String name, Person person) {
		this.name = name;
		this.person = person;
		this.size = size;
		this.pieces = pieces;
	}
    @Id
    @Column(name = "idHome")
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
	public Double getTaille() {
		return size;
	}
	public void setTaille(Double taille) {
		this.size = taille;
	}
	public Integer getPieces() {
		return pieces;
	}
	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
	public List<Heater> getHeater() {
		return heaters;
	}
	public void setHeater(List<Heater> heaters) {
		this.heaters = heaters;
	}
}
