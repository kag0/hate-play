CREATE TABLE pet (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR,
	type VARCHAR,
	status VARCHAR,
	photo_url VARCHAR
);

CREATE TABLE item (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR
);

CREATE TABLE orders (
	id BIGSERIAL PRIMARY KEY,
	pet_id BIGINT REFERENCES pet(id),
	item_id BIGINT REFERENCES item(id),
	quantity INT,
	order_date TIMESTAMP DEFAULT now()
);

INSERT INTO pet (name, type, status, photo_url) VALUES('fido', 'dog', 'available', 'https://upload.wikimedia.org/wikipedia/commons/a/a6/Dog_anatomy_lateral_skeleton_view.jpg');

INSERT INTO item (name) VALUES ('chew toy');

INSERT INTO orders (pet_id, item_id, quantity) VALUES (1, 1, 2);