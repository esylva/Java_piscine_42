create schema if not exists chat;

drop table if exists chat.msgs, chat.rooms, chat.users;

create table if not exists chat.users (
	id 		 serial primary key,
	login	 text not null,
	password text,
	rooms_id int[],
	chatrooms_id int[]
);

create table if not exists chat.rooms (
	id 		 serial primary key ,
	creator	 int not null references chat.users(id) ,
	name text not null
);

create table if not exists chat.room (
	id 		 serial primary key ,
	room_id  int not null references chat.rooms(id) ,
	sender	 int not null references chat.users(id) ,
	message  text not null ,
	time     timestamp
);