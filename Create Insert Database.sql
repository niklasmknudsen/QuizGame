drop table if exists questions
drop table if exists answers

create table questions(
id int identity primary key,
category varchar(40) not null,
field varchar(40) not null,
points int not null,
question text not null,
)

create table answers(
id int primary key,
AnswerName varchar(40),
questions int foreign key references questions(id),
trueAnswer bit,
forklaring text,
link varchar(40)
)

insert into questions values
('SCIENCE','Physics',12,'Wich physical property can be measured in the unit Coulomb')

insert into answers values
('Pressure', 1, 0, 'Not Correct', 'Link to correct answer: www.link.dk')
('Temperature', 1, 0, 'Not Correct', 'Link to correct answer: www.link.dk')
('Volume', 1, 0, 'Not Correct', 'Link to correct answer: www.link.dk')
('Force', 1, 0, 'Not Correct', 'Link to correct answer: www.link.dk')
('Charge', 1, 1, 'he SI unit for electric charge is Coulomb', 'https://en.wikipedia.org/wiki/Pascal_(unit)')
