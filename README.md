# taxcalculator
this is a set of APIs to be used by front-end engineers to develop an application
that store and display tax amounts.

# Condition
this application run in docker, so you must run registry and database(in this app, i use eureka and Postgre)
if u just wanna run this app in local, just remove environment eureka.serviceUrl.default and SPRING_DATASOURCE_URL in docker-compose.yml and config your database url in application.properties 

# How to get up and running
first you must clone this repo
https://github.com/jhonoman/taxcalculator.git
after that package with maven to be dockerfile
"mvn package dockerfile:build"
run with docker compose
"docker-compose up"
