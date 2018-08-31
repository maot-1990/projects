package com.pers.mongodb;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pers.mongodb.util.MongodbUtil;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
        MongodbUtil mongodbUtil = new MongodbUtil();
        System.out.println(mongodbUtil.getMongoDatabase().getName());
        final MongoDatabase database = mongodbUtil.getMongoDatabase();
        MongoCollection<Document> collection = database.getCollection("myDemoCollection");
        System.out.println(database.getCollection("myDemoCollection").getNamespace());
        collection.drop();
        Document document = new Document().append("title", "mongodb").
                append("type", "test").append("result", "info");
        Document document2 = new Document().append("title", "mongodb").
                append("type", "test").append("result", "info");
        List<Document> list = new ArrayList<Document>();
        list.add(document);
        list.add(document2);
        //collection.insertOne(document);
        //collection.insertOne(document2);
        collection.insertMany(list);
        System.out.println(collection.count());
        collection.find().forEach((Consumer<? super Document>) n -> System.out.println("lambda:" + n.entrySet()));

    }
}
