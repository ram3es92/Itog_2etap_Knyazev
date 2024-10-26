## Выполняемые команды для выполнения задач 7-12 и диаграмма для 6 задачи
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).
![Диаграмма](/Itog_2etap_Knyazev/MySQL/Animal_diagramm.jpeg)

7. В подключенном MySQL репозитории создать базу данных "Друзья человека”

```sql
CREATE DATABASE friendsofhuman;
```
8. Создать таблицы с иерархией из диаграммы в БД

```sql
USE friendsofhuman;
CREATE TABLE `animal` (
	`id` INT(5) NOT NULL AUTO_INCREMENT,
	`type` ENUM('pet', 'burden'),
	PRIMARY KEY (`id`)
);

CREATE TABLE `pet` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `animal` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `burden` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `animal` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `dog` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pet` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `cat` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pet` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `hamster` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pet` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `horse` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `burden` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `camel` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `burden` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `donkey` (
	`id` INT(5) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `burden` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);
```
9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

```sql
INSERT INTO friendsofhuman.animal (`type`) VALUES ('pet');
INSERT INTO friendsofhuman.pet (`id`, `name`) VALUES (LAST_INSERT_ID(), 'dog');
INSERT INTO friendsofhuman.`dog` (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'bobik', '2021-02-05', 'bark');

INSERT INTO friendsofhuman.animal (`type`) VALUES ('pet');
INSERT INTO friendsofhuman.pet (`id`, `name`) VALUES (LAST_INSERT_ID(), 'cat');
INSERT INTO friendsofhuman.`cat` (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'matilda', '2022-04-01', 'purr');

INSERT INTO friendsofhuman.animal (`type`) VALUES ('pet');
INSERT INTO friendsofhuman.pet (`id`, `name`) VALUES (LAST_INSERT_ID(), 'hamster');
INSERT INTO friendsofhuman.`hamster` (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'Homak', '2023-07-24', 'submit to the award');

INSERT INTO friendsofhuman.animal (`type`) VALUES ('burden');
INSERT INTO friendsofhuman.burden (`id`, `name`) VALUES (LAST_INSERT_ID(), 'horse');
INSERT INTO friendsofhuman.`horse` (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'gerkules', '2021-11-01', 'jump on an elephant');

INSERT INTO friendsofhuman.animal (`type`) VALUES ('burden');
INSERT INTO friendsofhuman.burden (`id`, `name`) VALUES (LAST_INSERT_ID(), 'camel');
INSERT INTO friendsofhuman.`camel` (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'vasya', '2010-01-01', 'spit');

INSERT INTO friendsofhuman.animal (`type`) VALUES ('burden');
INSERT INTO friendsofhuman.burden (`id`, `name`) VALUES (LAST_INSERT_ID(), 'donkey');
INSERT INTO friendsofhuman.`donkey` (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'bananchik', '2023-01-01', 'carrot');

```

10.  Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

```sql
DELETE FROM `animal` WHERE id IN (SELECT id FROM `camel`);
SELECT * FROM `horse`
UNION
SELECT * FROM `donkey`;
```