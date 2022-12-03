package com.felix.app.MongoRestApi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import com.felix.app.MongoRestApi.models.Livre;

import java.util.List;

@RestController
@RequestMapping(value = "/livre")
public class LivreService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MongoTemplate mongoTemplate;

    public LivreService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List < Livre > getAllUsers() {
        logger.info("Getting all books.");
        return mongoTemplate.findAll(Livre.class);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Livre getLivre(@PathVariable long id) {
        logger.info("Getting book with ID: {}.", id);
        Livre livreModel = mongoTemplate.findById(id, Livre.class);
        return livreModel;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Livre add(@RequestBody Livre livre) {
        logger.info("Saving book.");
        return mongoTemplate.save(livre);
    }
}