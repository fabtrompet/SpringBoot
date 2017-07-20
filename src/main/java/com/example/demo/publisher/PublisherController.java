package com.example.demo.publisher;

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
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    public PublisherRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Publisher>> queryAllPublishers(){
        return ResponseEntity.ok(repository.findAll());
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Publisher> saveAuthor(@RequestBody Publisher publisher){
        return ResponseEntity.ok(repository.save(publisher));
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void delPublisher(@RequestBody Publisher publisher){
        repository.delete(publisher.getId());
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Publisher> upAuthor(@RequestBody Publisher publisher){
        return ResponseEntity.ok(repository.save(publisher));
    }
}

