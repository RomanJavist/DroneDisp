-- Insering initial drones

INSERT INTO drone (id, model, load, load_max, battery_left, state)
VALUES ('D001', 'Lightweight', 0, 100, 100, 'IDLE');
INSERT INTO drone (id, model, load, load_max, battery_left, state)
VALUES ('D002', 'Middleweight', 0, 200, 100, 'IDLE');
INSERT INTO drone (id, model, load, load_max, battery_left, state)
VALUES ('D003', 'Cruiserweight', 0, 300, 100, 'IDLE');
INSERT INTO drone (id, model, load, load_max, battery_left, state)
VALUES ('D004', 'Heavyweight', 0, 500, 100, 'IDLE');
INSERT INTO drone (id, model, load, load_max, battery_left, state)
VALUES ('D005', 'Heavyweight', 0, 500, 100, 'IDLE');

-- Insering initial medications

INSERT INTO medication (code, name, weight, image)
VALUES ('M001', 'Medication #1', 10, 'images/M001.jpg');
INSERT INTO medication (code, name, weight, image)
VALUES ('M002', 'Medication #2', 20, 'images/M002.jpg');
INSERT INTO medication (code, name, weight, image)
VALUES ('M003', 'Medication #3', 30, 'images/M003.jpg');
INSERT INTO medication (code, name, weight, image)
VALUES ('M004', 'Medication #4', 40, 'images/M004.jpg');
INSERT INTO medication (code, name, weight, image)
VALUES ('M005', 'Medication #5', 50, 'images/M005.jpg');