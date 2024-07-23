use my_database;
db.users.find();

db.users.insert({username: 'smith'});
db.users.find();

// 0722 실습
use tutorial; // use 데이터베이스명

db.users.insert({username: 'smith'}); // tutorial 데이터베이스의 users 컬렉션에 문서 저장
db.users.find(); // tutorial 데이터베이스의 users 컬렉션에 문서 질의

db.users.insert({username: 'jones'});
db.users.count();
db.users.find();
// _id : 자동으로 생성되는 Primary Key / ObjectId("...") : ... 는 UUID



