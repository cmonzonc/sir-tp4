package opower;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person {
    private List<Home> homes = new ArrayList<Home>();
    private List<Person> friendships = new ArrayList<Person>();
    private Integer id;
    private String name;
    private String surname;
    private String mail;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String surname, String mail) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "a";

        // return "Employee [id=" + id + ", name=" + name + ", department="
        // + home.getName() + "]";
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
        name = "Friendship",
        joinColumns = { @JoinColumn(
            name = "idPersonFriend1",
            referencedColumnName = "idPerson"
        ) },
        inverseJoinColumns = { @JoinColumn(
            name = "idPersonFriend2",
            referencedColumnName = "idPerson"
        ) }
    )
    public List<Person> getFriends() {
        return friendships;
    }

    public void setFriends(List<Person> friendships) {
        this.friendships = friendships;
    }

    @OneToMany(
        mappedBy = "person",
        cascade = CascadeType.PERSIST
    )
    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    @Id
    @Column(name = "idPerson")
    @GeneratedValue
    public Integer getId() {
    	
    		if (this == null)
    		     throw new IllegalArgumentException("The argument cannot be null");
    	
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
}