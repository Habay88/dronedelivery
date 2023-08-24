INTRODUCTION
Drone Fleet Management API
The Drone Management API is a Spring Boot application that enables users to manage drones and their loaded medications based on the weight of the drone and its carrying capacity. Drones can be loaded with medical items, and their battery levels and states can be monitored. This API provides a set of endpoints for interacting with drones and medications.

 Table of Contents

1 INSTALLATION
2. RUNNING THE APPLICATION
3. API ENDPOINTS
4.DRONE
5.MEDICATION
6.COMMIT HISTORY
7. DEPENDENCIES USED 
8. API USAGE

1.0 --Git clone the repository with: https://github.com/Habay88/dronedelivery.git
       -cd dronedelivery
2.0 Running the Application
- Build the project with mnv clean install
- mvn spring-boot:run
-  Pre-loaded datas will be loaded on db on the first run 
- the application will start on port : 8082:  
                                                http://localhost:8082

3.0 API ENDPOINTS
4.0 DRONE:
 POST :  /drone  CREATES A NEW DRONE 
sample data json format
{
    "serialNumber": "genghis123454",
    "model": "HEAVYWEIGHT",
    "weightLimit":500,
    "batteryCapacityPercentage": 10,
    "batteryState" : "DRAINING",
    "droneState": "3"

}

5.0  MEDICATIONS:
POST : /medication   : CREATES A NEW MEDICATION
  Sample data in json format                    
{
    "name":"vit-a",
    "weight": "600",
    "code": "SKY303___1334",
    "image" : "qwertyuioplkjhgfdsa"
}


POST : /drone/{droneid}/load-medication/{medicationid}    : Load medication on a given drone base on   its carrying capacity the drone id and medication id  


GET : /drone/{droneid}                    :  GET THE DRONE INFO BASED ON THE ID

GET : /available-drone                       :  GET AVAILABLE DRONE BASED ON THE IDLE STATE
GET : /{droneid}/batteryLevel                    :    GET INFO ABOUT THE BATTERY LEVEL
POST : /drone/{droneid}/set-loading    :  Prevent the drone from being in LOADING state if the battery level is **below 25%**;

6.0  COMMIT HISTORY

git log --oneline --author="biodun.banjoko@yahoo.com" --since "2023-21-08"
Sample response 
cabb228 (HEAD -> main) readme update
140e9b8 commit history log yet to attached
9fe2e06 checking for multiple entry 4 datainitializer
4438fc2 preloaded data completed
aeb28ec preloaded date for drone using data initalizer
68ede14 datpreloader cmdlinerunner
fbce80c commandline runner wip
8c33e18 readme file documentation wip
49fa5bb scheduled 30 minutes working fine
6f59d19 scheduling batteryhistorlog
cc7396c periodic task 4 drones battery levels nt working
7af6b79 wip

7.0 DEPENDENCIES USED 
Java version 17 was use for this task
Spring-boot-starter-data-jpa : for  connecting Spring application with relational database efficiently.
Spring-boot-starter-web : For building RESTful applications using Spring MVC.
Spring-boot-starter-validation : it automatically bootstraps the default JSR 380 implementation — Hibernate Validator — and validates the argument
Jakarta.validation-api: it allows to validate single class instances but also complete object graphs (cascaded validation)
Hibernate-validator : It  allows to express and validate application constraints
Mysql-connector-j :  it provides connectivity for client applications
Lombok : it is  used to reduce boilerplate code for model/data objects,


8.0  API USAGE
The provided API endpoints are  to manage drones and medications.
 Load medications onto drones, monitor battery levels, and track their states.
 Proper input validation where created for the drones and medications via postman.
 Errors were properly  handled with custom exceptions
 Periodic task to check drones battery levels and create history log for this.
Pre loaded data will automatically populate the db . pls check your db config to conform with the declared db properties in the applications.yaml
Mysql database was used as the database 

Best Regards.
