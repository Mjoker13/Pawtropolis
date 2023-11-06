---------ITEM POPULATION -------------------
INSERT INTO item(name, description, slot_required)
VALUES ('Hammer', 'Use it to break things', 3),
       ('Water', 'Use it to quench your thirst', 2),
       ('Knife', 'use it to spread the Nutella', 2),
       ('Banana', 'Give it to the animals', 1),
       ('Apple', 'Give it to the animals', 1),
       ('Cane', 'Relax with animals', 1),
       ('Gas', 'Drink to suicide', 1),
       ('Nutella', 'Paradise moment', 2),
       ('Screwdriver', 'To be', 2),
       ('Chainsaw', 'Cut all', 4),
       ('Electric chair', 'use for cook the chicken', 4),
       ('Chicken', 'Cook it with the electric chair', 4),
       ('Old bread', 'It cuts with chainsaw', 4);

--------PLAYER BAG POPULATION-----------------
INSERT INTO player_bag(max_capacity)
VALUES (20);

--------PLAYER POPULATION-------------------
INSERT INTO player(name,life_points)
VALUES ('CICCIO',100);

---------ROOM POPULATION--------------------
INSERT INTO room(name)
VALUES ('A1'),
       ('A2');

------- ANIMAL POPULATION----------
INSERT INTO animal(name, favorite_food, age, entry_date, weight, height)
values('Oscar', 'rubbit', 23, '2012-8-20', 82.5, 95),
      ('Nala', 'gazelles', 15, '2015-5-28', 82, 108),
      ('Olimpia', 'fish', 22, '2008-9-13', 20, 70);

