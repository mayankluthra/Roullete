create table User(
    Id int primary key AUTO_INCREMENT,
    Name varchar(250),
    Email varchar(50),
    Password varchar(250),
    Status varchar(20),
    role varchar(20),
    UNIQUE (Email)
);

insert into User(Name, Email, Password, Status, role) values ('Admin', 'admin@admin.com','admin', 'true', 'admin');