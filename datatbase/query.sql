create database exam;
use exam;



create table product (
    productId int(11) not null primary key auto_increment ,
    name varchar(200) not null,
    price float(11,1) not null,
    quantity int(10) not null ,
    color varchar(50) not null ,
    desc varchar(200) not null ,
    catelog
    constraint fk_guest foreign key (guestId) references guest(guestId)
        on delete cascade
        on update cascade ,
    constraint fk_branch foreign key (branchId) references branch(branchId)
        on delete cascade
        on update cascade
);
ALTER TABLE `orders` ADD UNIQUE `unique_index`(`date`, `time`,`guestId`,`branchId`);