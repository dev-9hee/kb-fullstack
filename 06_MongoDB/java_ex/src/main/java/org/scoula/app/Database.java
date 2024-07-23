package org.scoula.app;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

// MongoDB 데이터베이스와의 연결을 관리하는 클래스
// 데이터베이스와의 연결을 설정하고, 특정 컬렉션에 접근하는 메서드를 제공
public class Database {
    static MongoClient client; // MongoDB 클라이언트
    static MongoDatabase database; // MongoDB 데이터베이스

    static { // 정적 블록은 클래스가 처음 로드될 때 한 번 실행
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017"); // MongoDB 서버의 URL 을 설정
        client = MongoClients.create(connectionString); // MongoDB 클라이언트를 생성
        database = client.getDatabase("todo_db"); // 지정한 데이터베이스(todo_db)를 가져옴, 데이터베이스가 없을시 이때 생성이 됨
    }

    public static void close() {
        client.close(); // MongoDB 클라이언트를 닫음, 애플리케이션 종료 시 자원을 해제하기 위해 사용
    }

    public static MongoDatabase getDatabase() {
        return database; // 데이터베이스 객체를 반환, 이 메서드를 통해 데이터베이스 접근 가능
    }

    // 컬렉션 반환 메서드, 컬렉션 이름을 인자로 받아 해당 컬렉션 객체를 반환
    // 컬렉션 : 테이블이라고 생각
    public static MongoCollection<Document> getCollection(String colName) {
        MongoCollection<Document> collection = database.getCollection(colName);
        return collection;
    }
}
