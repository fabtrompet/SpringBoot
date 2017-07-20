package com.example.demo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by meruem on 19/07/17.
 */
@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    public AuthorRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Author>> queryAllAuthors(){
        return ResponseEntity.ok(repository.findAll());
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Author> saveAuthor(@RequestBody  Author author){
        return ResponseEntity.ok(repository.save(author));
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void delAuthor(@RequestBody Author author){
        repository.delete(author.getId());
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Author> upAuthor(@RequestBody Author author){
        return ResponseEntity.ok(repository.save(author));
    }
}
