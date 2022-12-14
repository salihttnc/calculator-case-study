**SG VETERIS CASE STUDY**

Basic calculator project with given records. I used Spring Boot, PostgresSQL and Docker.

**Getting Started**

First, you need to clone the project to your local machine

* `git clone https://github.com/salihttnc/calculator-case-study.git`
* `cd calculator-case-study`

**Building**
A step by step series of building that project
1. Run PostgresSQl  for project use 
2. Update application.yaml or application.properties (Which you are working stage)
3. Restore project with maven  `mvn clean install -DskipTests`
4. Run with java -jar ShippingCaseStudy.jar

**Building with Docker** 

If you want to run with docker you should run the following commands : 
1. Create jar file for `mvn clean install -DskipTests `
2. Build docker image with Dockerfile : `docker build -t calculator-case-study:1.0 . `
3. Start the project with MongoDB :` docker-compose -f docker-compose.yml up -d`


Also, you can use `./start.sh`for all at once, but you have to run  `chmod +x ./start.sh` command before run the script.



****Build With****
1. Spring Boot 
2. Spring Data JPA - Spring Application with JPA(Java Persistent API)
3. PostgresSQL
4. Swagger - API developer tools for testing and documentation

**Contributing**
If you want to contribute to code, create pull request
If you find any bugs or error, create an issue



