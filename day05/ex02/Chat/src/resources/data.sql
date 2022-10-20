insert into chat.users (login, password, rooms_id, chatrooms_id) values ('esylva', 'school21', '{1,2}', '{1,2,3,4,6}');
insert into chat.users (login, password, rooms_id, chatrooms_id) values ('hdale', 'school', '{3}', '{1,2,3,4,6}');
insert into chat.users (login, password, rooms_id, chatrooms_id) values ('obeedril', 'school', '{5}', '{1,2,3,4,5}');
insert into chat.users (login, password, rooms_id, chatrooms_id) values ('ateak', 'Kate', '{4}', '{1,2,3,4,6}');
insert into chat.users (login, password, rooms_id, chatrooms_id) values ('Arina(ADM)', 'ADM', '{6}', '{1,2,3,4,6}');

insert into chat.rooms (creator, name) values (1, 'general');
insert into chat.rooms (creator, name) values (1, 'random');
insert into chat.rooms (creator, name) values (2, 'clubs and srades');
insert into chat.rooms (creator, name) values (3, 'hearts and diamonds');
insert into chat.rooms (creator, name) values (4, 'salo');
insert into chat.rooms (creator, name) values (5, 'capybaras');

insert into chat.msgs (room_id, sender, message, time) values (1, 1, 'Hello world', to_timestamp('2022 Jul 26 10:00'));
insert into chat.msgs (room_id, sender, message, time) values (2, 1, 'Hello world', to_timestamp('2022 Jul 26 10:02'));
insert into chat.msgs (room_id, sender, message, time) values (2, 2, 'Hello everyone!', to_timestamp('2022 Jul 26 10:03'));
insert into chat.msgs (room_id, sender, message, time) values (3, 3, 'Hi', to_timestamp('2022 Jul 26 10:04'));
insert into chat.msgs (room_id, sender, message, time) values (3, 4, 'Hello', to_timestamp('2022 Jul 26 10:02'));
insert into chat.msgs (room_id, sender, message, time) values (4, 4, 'Hey salo', to_timestamp('2022 Jul 26 10:05'));
insert into chat.msgs (room_id, sender, message, time) values (1, 5, 'HELLO EVERYONE', to_timestamp('2022 Jul 26 10:06'));
insert into chat.msgs (room_id, sender, message, time) values (5, 5 , 'Hello capybaras', to_timestamp('2022 Jul 26 10:01'));
