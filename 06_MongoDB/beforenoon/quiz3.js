// 1번
use test;

for (let i = 0; i < 20000; i++) {
    db.product.insertOne(
        { num : i, name : '스마트폰' + i }
    )
};

// 2번
db.product.countDocuments(); // 최신
// db.product.count();

// 3번
db.product.find().sort({ num : -1 }); // +1 : 오름차순, -1 : 내림차순

// 4번
db.product.find().sort({ num : -1 }).limit(10);

// 5번
db.product.find().sort({ num : -1 }).skip(10 * 5).limit(10); // 한 페이지당 10건씩 출력,  6페이지에 해당하는 문서

// 6번
db.product.find({
    $or : [
        { num : { $lt : 15 } },
        { num : { $gt : 19995 }}
    ]
});

// 7번
db.product.find({
    name : {
        $in : ['스마트폰10', '스마트폰100', '스마트폰1000']
    }
});

// 8번
db.product.find({ num : { $lt : 5 }}, { _id : 0, name : 1 }); // 출력할 항목은 1, 출력하기 싫은 애는 0

db.product.find();