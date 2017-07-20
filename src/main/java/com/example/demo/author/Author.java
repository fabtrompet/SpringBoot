package com.example.demo.author;

import com.example.demo.pub.Pub;
import com.example.demo.publisher.Publisher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by meruem on 19/07/17.
 */
@Entity
public class Author {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator( name = "increment", strategy = "increment")
    private Integer id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Collection<Pub> pubs;

    public Author(){

    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Pub> getPubs() {
        return pubs;
    }

    public void setPubs(Collection<Pub> pubs) {
        this.pubs = pubs;
    }
}
