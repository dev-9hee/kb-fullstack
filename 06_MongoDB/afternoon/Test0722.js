use test; // 테스트 데이터베이스 사용

// 선택된 테스트 데이터베이스를 db로 부름
// users는 컬렉션명
db.users.find(); // 전체 검색

// 하나의 도큐먼트를 삽입
db.users.insertOne({ name: "공연정", age: 25 });

// 야라 도큐먼트를 한번에 삽입, 배열에 담긴 객체 형태로 전달
db.users.insertMany([{ name: "최현수", age: 27 }, { name: "이태웅", age: 27 }]);

// 초간단 실습2
db.users.insertOne({ name: "뽀로로", age: 9 });
db.users.insertMany([{ name: "이예지", age: 26 }, { name: "김연비", age: 30 }, { name: "임준수", age: 29},
                    { name: "김서연", age: 25}, { name: "박혜원", age: 28 }]);
db.users.find(); // 전체 검색       

// 데이터 수정
db.users.updateOne(
    { name: "na" },
    { $set: { name: "나건우" } }
);

// 조건을 만족하면 다 수정
db.users.updateMany(
    { name: { $ne : "나건우"}}, // 조건 : name 필드가 나건우가 아닌 사람 전부
    { $set: { position: "RM 아님" }} // 변경 사항
);

db.users.updateMany(
    { age: { $lte : 30 }}, // 조건 : 나이가 30보다 작거나 같은 사람
    { $set: { status: "파릇파릇함" }} // 변경 사항
);
db.users.find(); // 전체 검색         

// 조건을 만족하는 가장 처음의 도큐먼트 하나를 삭제
db.users.deleteOne({ name: "뽀로로" }); // 몇 개의 데이터가 삭제되었는지 정보 리턴
// 조건을 만족하는 모든 도큐먼트를 삭제
db.users.deleteMany({ age: { $lte: 10 }});

// 조건에 맞는 값 찾기
db.users.findOne({ name: "이효석" });
// 여러 개 찾기
db.users.find({ age: { $lt: 30 }}); // 나이가 30살 미만

db.users.find(
    { $and: [
        { position: "RM" }, // position이 RM인 사람
        { age: { $gt: 20 }} // 나이가 20살 이상이면서
    ]}
);

db.users.find(
    { $or: [
        { name: "이효석" }, // 이름이 이효석 이거나
        { age: { $lt: 25 }} // 나이가 25살 미만인 사람
    ]}
);

// 실습, 데이터 삽입 - 수정 - 삭제 - 검색하기
use test2; // 데이터 베이스 생성

db.users.find();

db.users.insertOne({ name: "김이수", age: 25 });
db.users.find();

db.users.insertMany([
    { name: "나건우", age: 28 },
    { name: "최민준", age: 26 },
    { name: "권오현", age: 30 },
    { name: "김시완", age: 30 }
]);
db.users.find();

db.users.insertOne({ name: "이효석", age: 40 });
db.users.find();

db.users.updateMany(
    { age : { $gte : 37 }},
    { $set : { status : "늙음" } }
);
db.users.find();

db.users.deleteOne({ age : { $gte : 37 }}, { name : "이효석" });
db.users.find();

db.users.find({age : { $gte : 25 }});


                    