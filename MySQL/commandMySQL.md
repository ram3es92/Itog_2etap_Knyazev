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
