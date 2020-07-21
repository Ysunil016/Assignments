# Getting Started


#Assumptions - 
	Rating is Based on 10 Points...
	Driver and Passenger ID is Unique
	Ride ID is Uniques based on Ride Generated.


#Technology Usage - 
	MongoDb as Database
	Spring Boot Framework for MicroService
	
	
# Setup Required - 
	MongoServer Should be Running in Local System at 27017 PORT.

PORT - 80



#API to Give Rating to Driver

METHOD - POST
ENDPOINT - /v1/rating/giveRatingToDriver
RESPONSE - Boolean

Example - 

http://127.0.0.1:80/v1/rating/giveRatingToDriver

BODY - 
{
	"rideId":"215VTSYA",
	"passengerId":"YSunil016",
	"driverId":"Abdul008",
	"rating":8
}
	


#API to Give Rating to Driver

METHOD - POST
ENDPOINT - /v1/rating/giveRatingToPassenger
RESPONSE - Boolean

Example - 

http://127.0.0.1:80/v1/rating/giveRatingToPassenger

BODY - 
{
	"rideId":"215VTSYA",
	"passengerId":"YSunil016",
	"driverId":"Abdul008",
	"rating":9
}



#API for AggregatedRating of a Driver

METHOD - GET
ENDPOINT - /v1/rating/getAggregatedRating/driver/{driverId}
RESPONSE - Float

Example
http://127.0.0.1:80/v1/rating/getAggregatedRating/driver/Abdul008

@PathVariable - driverId

#API for AggregatedRating of a Passenger

METHOD - GET
ENDPOINT - /v1/rating/getAggregatedRating/passenger/{passengerId}
RESPONSE - Float
	
Example
http://127.0.0.1:80/v1/rating/getAggregatedRating/driver/YSunil016

	
@PathVariable - passengerId