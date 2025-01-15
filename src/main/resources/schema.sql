DROP TABLE IF EXISTS restaurant_db.agenda;
DROP TABLE IF EXISTS restaurant_db.reservation;

CREATE TABLE IF NOT EXISTS restaurant_db.agenda (
    id BIGINT NOT NULL AUTO_INCREMENT,
    day VARCHAR(255),
    start_time TIME,
    end_time TIME,
    is_available BOOLEAN,
    PRIMARY KEY (id)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS restaurant_db.reservation (
    id BIGINT NOT NULL AUTO_INCREMENT,
    day VARCHAR(255),
    end_time TIME,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    num_people INT NOT NULL,
    start_time TIME,
    PRIMARY KEY (id)
) ENGINE=InnoDB;