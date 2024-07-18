DROP TABLE IF EXISTS travel;
CREATE TABLE travel
(
    no          INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    district    VARCHAR(50)  NOT NULL,
    title       VARCHAR(512) NOT NULL,
    description TEXT,
    address     VARCHAR(512),
    phone       VARCHAR(256)
);

DROP TABLE IF EXISTS travel_image;
CREATE TABLE travel_image (
  no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  travel_no INT,
  file_name VARCHAR(128) NOT NULL,
  path VARCHAR(512) NOT NULL,
  size INT,
  CONSTRAINT FOREIGN KEY(travel_no) REFERENCES travel(no)
);

SELECT * FROM travel;
SELECT * FROM travel_image;