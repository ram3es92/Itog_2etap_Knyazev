## Задание
1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

```shell
sudo su
mkdir finaltest
cd final test
nano pets.txt
> вписать данные
nano burden.txt
> вписать данные
cat pets.txt burden.txt > animals.txt
cat animals.txt
mv animals.txt all_animals.txt
```
![Скриншот_1](/Itog_2etap_Knyazev/LinuxCommand/Screenshot/01.jpeg)

2. Создать директорию, переместить файл туда.
```shell
mkdir example
mv all_animals.txt example
cd example
ls
```
![Скриншот_2](/Itog_2etap_Knyazev/LinuxCommand/Screenshot/02.jpeg)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
```shell
apt install mysql-server
```
![Скриншот_3](/Itog_2etap_Knyazev/LinuxCommand/Screenshot/03.jpeg)
![Скриншот_4](/Itog_2etap_Knyazev/LinuxCommand/Screenshot/04.jpeg)

4. Установить и удалить deb-пакет с помощью dpkg.
```shell
apt download libfuse2
ls
dpkg -i libfuse
apt remove libfuse2
```
![Скриншот_5](/Itog_2etap_Knyazev/LinuxCommand/Screenshot/05.jpeg)
![Скриншот_6](/Itog_2etap_Knyazev/LinuxCommand/Screenshot/06.jpeg)

5. Выложить историю команд в терминале ubuntu
```shell
history
```
![Скриншот_7](/Itog_2etap_Knyazev/LinuxCommand/Screenshot/07.jpeg)