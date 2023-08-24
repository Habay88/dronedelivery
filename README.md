# dronedelivery
Drone Fleet Management API
The Drone Management API is a Spring Boot application that enables users to manage drones and their loaded medications based on the weight of the drone and its carrying capacity. Drones can be loaded with medical items, and their battery levels and states can be monitored. This API provides a set of endpoints for interacting with drones and medications.

> Table of Contents

> Installation
> Running the Application
> API Endpoints
> Drone
> Medication
> Commit history

1. Git clone the repository with: https://github.com/Habay88/dronedelivery.git
       cd dronedelivery

2. Build the project with mnv clean install

3. running the application:
mvn spring-boot:run
4. pre-loaded datas will be preloaded on db on the first run 
5 . the application will start on port : 8082:  
                                                http://localhost:8082

API ENDPOINTS
DRONE:
> POST :  /drone  CREATES A NEW DRONE 
sample data using postman or insomnia 
{
    "serialNumber": "genghis123454",
    "model": "HEAVYWEIGHT",
    "weightLimit":500,
    "batteryCapacityPercentage": 10,
    "batteryState" : "DRAINING",
    "droneState": "3"

}

> MEDICATIONS:
POST : /medication   CREATES A NEW MEDICATION
                      
{
    "name":"vit-a",
    "weight": "600",
    "code": "SKY303___1334",
    "image" : "qwertyuioplkjhgfdsa"
}


POST : /drone/{droneid}/load-medication/{medicationid}    : LOAD MEDICATION ON A GIVEN DRONE BASE ON   ITS CARRYING CAPACITY THE DRONE ID AND MEDICATION ID  


GET : /drone/{droneid}                    :  GET THE DRONE INFO BASED ON THE ID

GET : /available-drone     :  GET AVAILABLE DRONE BASED ON THE IDLE STATE
GET : /{droneid}/batteryLevel       GET INFO ABOUT THE BATTERY LEVEL
POST : /drone/{droneid}/set-loading      Prevent the drone from being in LOADING state if the battery level is **below 25%**;

  > COMMIT HISTORY on your git bash
 > git log --oneline --author="biodun.banjoko@yahoo.com" --since "2023-21-08"

PS C:\Users\lbanjoko\Documents\GitHub\dronedelivery> git log --oneline --author="biodun.banjoko@yahoo.com" --since "2023-21-08"
Re
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
:

Usage
>The provided API endpoints are  to manage drones and medications.
> Load medications onto drones, monitor battery levels, and track their states.
> Proper input validation where created for the drones and medications via postman.
> Errors were properly  handled with custom exceptions
> periodic task to check drones battery levels and create history log for this.
> pre loaded data will automatically populate the db . pls check your db config to conform with the declared db properties in the applications.yaml
> mysql database was used as the database 
