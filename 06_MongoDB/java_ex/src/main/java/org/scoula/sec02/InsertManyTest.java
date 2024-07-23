package org.scoula.sec02;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;
import org.scoula.app.Database;

import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        List<Document> insertList = new ArrayList<>();

        Document document1 = new Document();
        Document document2 = new Document();

        document1.append("title", "Dune2 영화보기");
        document1.append("desc", "이번 주말 IMAX 로 Dune2 영화보기");
        document1.append("done", false);

        document2.append("title", "Java MongoDB 연동");
        document2.append("desc", "Java 로 MongoDB 연동 프로그래밍 연습하기");
        document2.append("done", false);

        insertList.add(document1);
        insertList.add(document2);

        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());

        Database.close();
    }
}
