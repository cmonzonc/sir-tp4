package opower;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ElectronicDevice")
public class ElectronicDevice extends Device {
    private Integer consumption;
    private Person person;

    public ElectronicDevice() {
        super();
    }

    public ElectronicDevice(String name, int consumption, String unit) {
        super();
        this.consumption = consumption;
        this.name = name;
        this.unit = unit;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    @ManyToOne(optional = true)
    @JoinColumn(
        name = "idPerson",
        referencedColumnName = "idPerson"
    )
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}