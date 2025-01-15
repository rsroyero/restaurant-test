DROP TABLE IF EXISTS restaurant_db.reservation;
DROP TABLE IF EXISTS restaurant_db.agenda;

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
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    num_people INT NOT NULL,
    day VARCHAR(255) NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    agenda_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (agenda_id) REFERENCES agenda (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;