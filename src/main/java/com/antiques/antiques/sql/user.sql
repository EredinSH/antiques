CREATE DATABASE antiques;

CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    age INT(3) NOT NULL,
    nick VARCHAR(50),
    mail VARCHAR(100) NOT NULL,
    account DOUBLE(8,2) NOT NULL
);

INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Bogdan','Espan',28,'Bogdano','acordeone@gmail.com',25000.00);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Nikita','Romanov',34,null,'car123@gmail.com',85500.25);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Garry','Coolman',48,null,'garryCool@gmail.com',37700.00);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Jose','Purro',24,'JPurr','messageHere@gmail.com',14820.00);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Matilda','Rosa',33,'MatildaOneOne','matiER@gmail.com',55750.50);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Jonathan','Bernn',27,'Jonas','furD@gmail.com',22300.00);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Carmen','Baske',55,null,'baskeCar@gmail.com',128000.00);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('John','Smith',47,'JohnUSA','johnSmith@gmail.com',154500.00);
INSERT INTO user (name, surname, age, nick, mail, account) VALUES ('Alhum','Bahhantur',39,'All_deal','alhumCompanyHouse@gmail.com',275750.00);
