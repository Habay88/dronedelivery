Drone Fleet Management API
The Drone Management API is a Spring Boot application that enables users to manage drones and their loaded medications based on the weight of the drone and its carrying capacity. Drones can be loaded with medical items, and their battery levels and states can be monitored. This API provides a set of endpoints for interacting with drones and medications.

> Table of Contents

> Installation
> Running the Application
> API Endpoints
> Drone
> Medication

1. Git clone the repository with: https://github.com/Habay88/dronedelivery.git
       cd dronedelivery

2. Build the project with mnv clean install

3. running the application:
mvn spring-boot:run

4. the application will start on port : 8082:  
http://localhost:8082

API ENDPOINTS
DRONE:
> POST :  /drone  CREATES A NEW DRONE 
sample data
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
             (droneid)         (medicationid)
{
    "name":"vit-a",
    "weight": "600",
    "code": "SKY303___1334",
    "image" : "qwertyuioplkjhgfdsa"
}


POST : /drone/1/load-medication/1    : LOAD MEDICATION ON A GIVEN DRONE BASE ON   ITS CARRYING CAPACITY THE DRONE ID AND MEDICATION ID  


GET : /drone/1                    :  GET THE DRONE INFO BASED ON THE ID

GET : /available-drone     :  GET AVAILABLE DRONE BASED ON THE IDLE STATE
GET : /1/batteryLevel       GET INFO ABOUT THE BATTERY LEVEL
POST : /drone/1/set-loading      Prevent the drone from being in LOADING state if the battery level is **below 25%**;

N.B: the Id represented in the Pathvariables indicates the droneid and medicationid respectively based on the name before the number 

Usage
>The provided API endpoints are  to manage drones and medications.
> Load medications onto drones, monitor battery levels, and track their states.
> Proper input validation where created for the drones and medications.
> Error were handled with custom exceptions
> periodic task to check drones battery levels and create history
log for this.
> mysql database was used as the database 