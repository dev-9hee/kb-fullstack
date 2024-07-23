package org.scoula.sec04;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.scoula.app.Database;

import static com.mongodb.client.model.Filters.eq; // static 메서드 임포트로 간소화해서 사용

// MongoDB 데이터베이스에서 특정 ID를 가진 문서를 업데이트하는 기능
public class UpdateOneTest {
    public static void main(String[] args) {
        // 'users' 컬렉션 가져오기
        MongoCollection<Document> collection = Database.getCollection("users");

        // 검색할 문서의 ID 설정
        String id = "669f0bbc38a0ba491257ced9";
        Bson query = eq("_id", new ObjectId(id));

        // 업데이트 작업 설정
        Bson updates = Updates.combine( // Updates.combine 메서드를 사용하여 여러 업데이트 작업을 결합
                Updates.set("name", "modify name"), // name 필드 값을 "modify name"으로 설정
                Updates.currentTimestamp("lastUpdated")); // lastUpdated 필드를 현재 타임스탬프로 설정

        // 문서 업데이트
        UpdateResult result = collection.updateOne(query, updates); // 조건에 맞는 첫 번째 문서를 업데이트 (쿼리, 수정내용)
        // UpdateResult 객체를 반환하며, 수정된 문서의 수를 포함
        System.out.println("==> UpdateResult : " + result.getModifiedCount()); // 업데이트된 문서의 수를 출력

        // MongoDB 클라이언트 닫기
        Database.close();
    }
}
