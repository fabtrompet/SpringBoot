package com.example.demo.publisher;

import com.example.demo.pub.Pub;
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
public class Publisher {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator( name = "increment", strategy = "increment")
    private Integer id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private Collection<Pub> pubs;
    public Publisher(){

    }

    public Publisher(String name, String email, Collection<Pub> pubs) {
        this.name = name;
        this.email = email;
        this.pubs = pubs;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Pub> getPubs() {
        return pubs;
    }

    public void setPubs(Collection<Pub> pubs) {
        this.pubs = pubs;
    }
}
