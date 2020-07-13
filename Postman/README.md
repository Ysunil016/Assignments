# Postman_Assignment
Postman Timely Project Assignment

** Use Postman as an Client for REST APIs **<br>
** Project Start at Port 80 **


<b>Project allows to </b>- <br>
        
        Register/Create User, <br>
        Login with valid credentials, <br>
        Fetch all the available slots for his/her profile, <br>
        Fetch all the available slots for other's profile,<br>
        Mark Slot Available in his Profile, <br>
        Book an Available Slot for Other's Profile, <br>
        Fetch all the bookings of his/her profile, <br>
        Fetch all the booked slots for other's profile.<br>

   
<b>Reference Links</b><br>

    User Guide Link - https://github.com/Ysunil016/Postman_Assignment/blob/master/User_Guide.pdf
    POC Images Link - https://github.com/Ysunil016/Postman_Assignment/tree/master/Pictures
    Java Docs - https://github.com/Ysunil016/Postman_Assignment/tree/master/Java_Docs


<b>All Project REST APIs</b> 

    1. User Registration API :: 

        Endpoint :- http://127.0.0.1/v1/user/register
        Request Method :- POST
        Request Body :-
        {
            "username":"sunil016@yahoo.com",
            "password":"12345"
        }

    2. User Login API :: 

        Endpoint :- http://127.0.0.1/v1/user/login
        Request Method :- GET
        Authentication Header : Basic Authentication


    3. User Logout API :: 

        Endpoint :- http://127.0.0.1/v1/logout
        Request Method :- GET


    4. Fetch All the Available Slots for Your Profile :: 

        Endpoint :- http://127.0.0.1/v1/slot/getAllSlots
        Request Method :- GET


    5. Fetch All the Available Slots for Other's Profile :: 

        Endpoint :- http://127.0.0.1/v1/slot/getAllSlots/{username}
        Request Method :- GET

        ** By Default No Slot will be Available for Other's to Make Booking On


    6. Make Slot Available for Your Profile :: 

        Endpoint :- http://127.0.0.1/v1/slot/setSlotAvailable/{slotNumber}
        Request Method :- PUT

        **Here slotNumber is the TimeStamp - slotNumber I.e for 1200:1300 slotNumber is 12.


    7. Book a Available Slot for Other's Profile :: 

        Endpoint :- http://127.0.0.1/v1/booking/bookSlot
        Request Method :- POST
        Request Body :-
        {
            "to":"sanjay01@yahoo.com",
            "slot":10,
            "description":"Medical Checkup"
        }


    8. Fetch all your Today's Booking that You have done for Other's Profile.

        API	http://127.0.0.1/v1/booking/getAllBookings
        Request Method :- GET


    9. Fetch all your Today's Booked Slots for Your Profile

        API	http://127.0.0.1/v1/slot/getAllBookedSlots
        Request Method :- GET




<b>Technologies Used </b><br> 
        1. Java <br>
        2. SpringBoot <br>
        3. Spring Security <br>
        4. JPA <br>
        5. JUnit Mockito <br>
        6. Mongodb <br>
