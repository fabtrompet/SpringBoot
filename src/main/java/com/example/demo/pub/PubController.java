package com.example.demo.pub;

/**
 * Created by meruem on 19/07/17.
 */
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
@RequestMapping("/pubs")
public class PubController {
    @Autowired
    public PubRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pub>> queryAllPub(){
        return ResponseEntity.ok(repository.findAll());
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pub> savePub(@RequestBody Pub pub){
        return ResponseEntity.ok(repository.save(pub));
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void delPub(@RequestBody Pub pub){
        repository.delete(pub.getId());
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Pub> upPub(@RequestBody Pub pub){
        return ResponseEntity.ok(repository.save(pub));
    }
}

