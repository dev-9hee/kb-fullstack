package org.scoula.sec03;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.scoula.app.Database;

import java.util.Iterator;

public class FindTest {
    public static void main(String[] args) {
        // 컬렉션 가져오기
        MongoCollection<Document> collection = Database.getCollection("todo");

        // 컬렉션의 모든 문서 조회, 단순 조회
        // FindIterable<Document> 객체를 반환, 이 객체는 조회된 문서들을 반복(iterate)할 수 있게 함
        FindIterable<Document> doc = collection.find();

        // 조회 결과를 반복자(Iterator)로 처리
        Iterator itr = doc.iterator(); // 조회된 문서들의 반복자를 가져옴
        while (itr.hasNext()) { // 반복자가 다음 문서를 가리키고 있는 동안 반복
            // itr.next()를 호출하여 현재 문서를 가져오고, 이를 출력
            System.out.println("==> findResultRow : " + itr.next());
        }

        Database.close(); // MongoDB 클라이언트 닫기
    }
}
