package com.ratnikov.spring_data_mongo.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ratnikov.spring_data_mongo.model.Person;
import com.ratnikov.spring_data_mongo.repository.PersonRepository;
import org.bson.Document;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "stvort", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertLermontov", author = "kurochkin")
    public void insertLermontov(MongoDatabase db) {
        MongoCollection<Document> myCollection = db.getCollection("persons");
        var doc = new Document().append("name", "Lermontov");
        myCollection.insertOne(doc);
    }

    @ChangeSet(order = "003", id = "insertPushkin", author = "stvort")
    public void insertPushkin(PersonRepository personRepository) {
        personRepository.save(new Person("Pushkin"));
    }
}