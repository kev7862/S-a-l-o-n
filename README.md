# Project Name.
### Salon a.k.a Sukwa.
# Author.
### Kevin Matite.
# Description.
#### Application to manage a hair salon with stylists and clients using Java, PostgreSQL, and Spark with JUnit tests and RESTful routing.
# Technologies Used.
* Spark.
* java.
* postgresSQl.
* Html/CSS.
# Set-up Instructions.
* Clone directory
* Setup database in PSQL:
  * CREATE DATABASE hair_salon;
  * \c hair_salon
  * CREATE TABLE clients (id serial PRIMARY KEY, stylistid int, firstname varchar, lastname varchar, phonenumber varchar, email varchar, age int);
  * CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
  * CREATE TABLE appointments (id serial PRIMARY KEY, time varchar, procedureid int, clientid int);
  * CREATE TABLE procedures (id serial PRIMARY KEY, description varchar, price float);
  * CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;
# License.
copyright 2017[MIT]https://choosealicense.com/licenses/mit
