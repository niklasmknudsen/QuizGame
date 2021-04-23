insert into dbo.question values
('SCIENCE','Wich physical property can be measured in the unit Coulomb','Physics',12),
('test','Wich physical property can be measured in the unit Coulomb','Physics',14)

insert into dbo.answer values
('Pressure', 'The SI unit for Pressure is Pascal', 0, 'https://en.wikipedia.org/wiki/Pressure', 1),
('Temperature', 'The SI unit for Temperature is Kelvin', 0, 'https://en.wikipedia.org/wiki/Temperature', 1),
('Volume', 'The SI unit for Volume is Cubic Meter', 0, 'https://en.wikipedia.org/wiki/Volume', 1),
('Force', 'The SI unit for Force is Newton', 0, 'https://en.wikipedia.org/wiki/Force', 1),
('Charge', 'The SI unit for Electric Charge is Coulomb', 1, 'https://en.wikipedia.org/wiki/Pascal_(unit)', 1)


select * from dbo.Answer
--delete from dbo.Answer where id = 1
--select * from dbo.Answer



select * from dbo.AnsweredQuestion
select * from dbo.Question
