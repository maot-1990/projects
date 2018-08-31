package com.pers.mongodb.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongodbUtil {

    private final static String host = "127.0.0.1";
    private final static int port = 27017;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    public MongodbUtil() {
        init();
    }

    public void init(){
        mongoClient = new MongoClient(host, port);
        mongoDatabase = mongoClient.getDatabase("test");
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

}
