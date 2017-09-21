CREATE TABLE IF NOT EXISTS EVENTS (
  id VARCHAR(30) PRIMARY KEY,
  name VARCHAR(256),
  description TEXT,
  start_time DATETIME,
  finish_time DATETIME,
  image_url VARCHAR(128)
);