-- Insering initial drones

INSERT INTO drone (id, type, load, load_max, battery_left, state)
VALUES ('D001', 0, 0, 100, 100, 0);
INSERT INTO drone (id, type, load, load_max, battery_left, state)
VALUES ('D002', 1, 0, 200, 100, 0);
INSERT INTO drone (id, type, load, load_max, battery_left, state)
VALUES ('D003', 2, 0, 300, 100, 1);
INSERT INTO drone (id, type, load, load_max, battery_left, state)
VALUES ('D004', 3, 0, 500, 100, 0);
INSERT INTO drone (id, type, load, load_max, battery_left, state)
VALUES ('D005', 3, 0, 500, 100, 0);

-- Insering initial medications

INSERT INTO medication (code, name, weight)
VALUES ('M001', 'Medication #1', 10);
INSERT INTO medication (code, name, weight)
VALUES ('M002', 'Medication #2', 20);
INSERT INTO medication (code, name, weight)
VALUES ('M003', 'Medication #3', 30);
INSERT INTO medication (code, name, weight)
VALUES ('M004', 'Medication #4', 40);
INSERT INTO medication (code, name, weight)
VALUES ('M005', 'Medication #5', 50);