package org.scoula.sec03;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.scoula.app.Database;

import static com.mongodb.client.model.Filters.eq; // static 메서드 임포트로 간소화해서 사용

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        // 검색할 컬럼의 id 설정
        String id = "669f09d7cdde3a58185fc2ca";
        // _id 필드가 주어진 ID와 일치하는 쿼리 객체를 생성
        // ObjectId 클래스는 MongoDB의 기본 ID 형식을 나타냄
        Bson query = eq("_id", new ObjectId(id));

        // 쿼리로 단일 문서 조회
        Document doc = collection.find(query).first(); // 쿼리 조건에 맞는 첫 번째 문서를 조회
        System.out.println("==> findByIdResult : " + doc); // 조회된 문서를 출력

        // MongoDB 클라이언트 닫기
        Database.close();
    }
}
