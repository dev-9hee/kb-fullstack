package org.scoula.sec02;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.scoula.app.Database;

// MongoDB 데이터베이스에 단일 문서를 삽입하는 기능을 구현
// Database 클래스를 사용하여 MongoDB에 연결하고, 지정된 컬렉션에 문서를 추가한 후 삽입 결과를 출력
public class InsertOneTest {
    public static void main(String[] args) {
        // 이 메서드는 Database 클래스에서 정의된 정적 메서드로, 컬렉션 객체를 반환
        // 'todo' 컬렉션 가져오기
        MongoCollection<Document> collection = Database.getCollection("todo");

        // 새로운 문서 생성, document 가 row 라고 생각하면 됨
        Document document = new Document(); // Document 객체를 생성하여 MongoDB에 삽입할 데이터를 설정
        // title, desc, done 필드를 추가하고 각각의 값을 설정
        document.append("title", "MongoDB");
        document.append("desc", "MongoDB 공부하기");
        document.append("done", false);

        // 문서를 컬렉션에 삽입
        // InsertOneResult 객체를 반환하며, 삽입된 문서의 ID를 포함
        InsertOneResult result = collection.insertOne(document);
        // 삽입 결과의 ID를 출력
        System.out.println("==> InsertOneResult : " + result.getInsertedId());
        // MongoDB 클라이언트 닫기
        Database.close();
    }
}
