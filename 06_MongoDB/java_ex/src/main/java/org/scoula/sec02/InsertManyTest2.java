package org.scoula.sec02;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;
import org.scoula.app.Database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertManyTest2 {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        List<Document> insertList = new ArrayList<>();

        for (int i = 10; i < 21; i++) {
            Document document = new Document();
            document.append("name", "user_" + i);
            document.append("age", i);
            document.append("created", new Date());
            insertList.add(document);
        }

        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());

        Database.close();
    }
}
