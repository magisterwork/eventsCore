CREATE TABLE IF NOT EXISTS events (
  name        VARCHAR(256) NOT NULL,
  description TEXT,
  start_time  DATETIME,
  finish_time DATETIME,
  image_url   VARCHAR(128),
  ext_id      VARCHAR(128),
  system_id   VARCHAR(64),
  PRIMARY KEY(system_id, ext_id)
);

DROP TABLE EVENTS