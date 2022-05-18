create table if not exists products (id bigserial primary key, title varchar(255), price int DEFAULT floor(random()*(100-10)+10));

insert into products (title)
values ('Milk'),('Eggs'),('Nuts'),('Beer'),('Fish'),
       ('Ice cream'),('Curd cheese'),('Chicken'),('Apples'),('Bananas'),
       ('Chips'),('Lemonade'),('Chocolate'),('Tomatoes'),('Melon'),
       ('Coffee'),('Tea'),('Peanuts'),('Oranges'),('Olive oil');
