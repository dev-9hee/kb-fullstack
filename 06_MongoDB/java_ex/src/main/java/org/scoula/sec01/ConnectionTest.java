package org.scoula.sec01;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionTest {

    public static void main(String[] args) {

        String url = "mongodb://localhost:27017"; // url 변수에는 MongoDB 서버의 URL 을 설정
        String db = "todo_db"; // db 변수에는 연결할 데이터베이스 이름을 설정

        // try 블록이 끝날 때 MongoClient 가 자동으로 닫힙
        try (MongoClient client = MongoClients.create(url)) { // MongoClients.create(url) 메서드를 사용하여 MongoDB 클라이언트를 생성
            MongoDatabase database = client.getDatabase(db); // client.getDatabase(db) 메서드를 사용하여 지정한 데이터베이스를 가져옴
            System.out.println("MongoDB 연결 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
