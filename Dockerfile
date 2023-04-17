
#FROM maven:3.6.3-jdk-11 — базовый образ с предустановленным mvn 3.6.3 и jdk11
FROM maven:3.6.3-jdk-11
#RUN mkdir -p /usr/src/app — создание каталога /usr/src/app в контейнере
#RUN mkdir -p /usr/src/app
#WORKDIR /usr/src/app — задаёт рабочую директорию для следующей инструкции.
#WORKDIR /usr/src/app
#ADD . /usr/src/app — копирование файлов в директорию. см. ADD or COPY: https://docs.docker.com/develop/develop-images/dockerfile_best-practices/
#ADD . /usr/src/app
# RUN mvn clean test — выполняет команду и создаёт слой образа. Используется для установки в контейнер пакетов.
#RUN or CMD: https://www.geeksforgeeks.org/difference-between-run-vs-cmd-vs-entrypoint-docker-commands/#:~:text=A%20CMD%20command%20is%20used,the%20last%20one%20gets%20executed.
#Можно указать .sh для построение сложной логики запуска тестов, например, проверка на доступность тестируемого приложения
RUN mvn clean test

#docker build -t testdocker:1.0 . чтоб сбилдить имаж
# docker run -it --name apitest_preprod apitest_preprod:v1 /bin/bash для запуска консоли в контейнере
