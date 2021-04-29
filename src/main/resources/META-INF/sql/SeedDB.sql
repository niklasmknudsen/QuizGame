insert into dbo.question values
(newid(),'SCIENCE','Wich physical property can be measured in the unit Coulomb','Physics',12),
(newid(),'SCIENCE','Which design pattern is mostly used???','Computer Science',14)

insert into dbo.answer values
(newid(),'Pressure', 'The SI unit for Pressure is Pascal', 0, 'https://en.wikipedia.org/wiki/Pressure', (select ID from dbo.Question where field = 'Physics')),
(newid(),'Temperature', 'The SI unit for Temperature is Kelvin', 0, 'https://en.wikipedia.org/wiki/Temperature', (select ID from dbo.Question where field = 'Physics')),
(newid(),'Volume', 'The SI unit for Volume is Cubic Meter', 0, 'https://en.wikipedia.org/wiki/Volume', (select ID from dbo.Question where field = 'Physics')),
(newid(),'Force', 'The SI unit for Force is Newton', 0, 'https://en.wikipedia.org/wiki/Force', (select ID from dbo.Question where field = 'Physics')),
(newid(),'Charge', 'The SI unit for Electric Charge is Coulomb', 1, 'https://en.wikipedia.org/wiki/Pascal_(unit)', (select ID from dbo.Question where field = 'Physics')),
(newid(),'Singleton', 'singleton creates a instance of an object, witch can only be created once', 1, 'https://en.wikipedia.org/wiki/Singleton_pattern', (select ID from dbo.Question where field = 'Computer Science')),
(newid(),'Adapter', 'The SI unit for Temperature is Kelvin', 0, 'https://en.wikipedia.org/wiki/Temperature', (select ID from dbo.Question where field = 'Computer Science')),
(newid(),'Observer', 'The SI unit for Volume is Cubic Meter', 0, 'https://en.wikipedia.org/wiki/Volume', (select ID from dbo.Question where field = 'Computer Science')),
(newid(),'Iterator', 'The SI unit for Force is Newton', 0, 'https://en.wikipedia.org/wiki/Force', (select ID from dbo.Question where field = 'Computer Science')),
(newid(),'Composite', 'The SI unit for Electric Charge is Coulomb', 1, 'https://en.wikipedia.org/wiki/Pascal_(unit)', (select ID from dbo.Question where field = 'Computer Science'))


select * from dbo.Answer
select * from dbo.Question
select ID from dbo.Question where field = 'Physics'