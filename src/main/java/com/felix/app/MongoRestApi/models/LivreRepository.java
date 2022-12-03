package com.felix.app.MongoRestApi.models;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends MongoRepository < Livre, Long > {
    
}
