CREATE TABLE IF NOT EXISTS hall(
  id int AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20),
  planUrl VARCHAR(200),
  row int,
  seat int
);

CREATE TABLE IF NOT EXISTS movie(
  id int AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  genre VARCHAR(100),
  description VARCHAR(5000),
  duration int,
  startRelease Date,
  finishRelease Date,
  posterUrl VARCHAR(200),
  trailerUrl VARCHAR(2000)
);

CREATE TABLE IF NOT EXISTS session(
  id int AUTO_INCREMENT PRIMARY KEY,
  deliveryTime TIME,
  price INT,
  movieId int,
  hallId int
);

CREATE TABLE IF NOT EXISTS user(
  id int AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(100),
  password VARCHAR(20),
  firstName VARCHAR(50),
  lastName VARCHAR(50),
  email VARCHAR(50),
  sex VARCHAR(20),
  birthday DATE ,
  roleId int
);

CREATE TABLE IF NOT EXISTS ticket(
  id int AUTO_INCREMENT PRIMARY KEY,
  sessionId int,
  row INT,
  seat INT,
  userId INT
);

CREATE TABLE IF NOT EXISTS role(
  id int AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20)
);