package com.example.demo.pub;

import com.example.demo.author.Author;
import com.example.demo.publisher.Publisher;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

/**
 * Created by meruem on 19/07/17.
 */
@Entity
public class Pub {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private String title;

    @Enumerated(EnumType.STRING)
    private PubType type;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

    public Pub(){

    }
    public Pub(String title, PubType type, Author author, Publisher publisher) {
        this.title = title;
        this.type = type;
        this.author = author;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PubType getType() {
        return type;
    }

    public void setType(PubType type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
