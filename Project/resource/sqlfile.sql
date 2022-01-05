

use project;

create table loginInfo(

   id int not null auto_increment,
   username varchar(255) not null,
   password varchar(255) not null,
   primary key(id)
);

insert into loginInfo(username,password)
values("mithun",1234),
       ("fahin",2345);
       
select username from loginInfo;