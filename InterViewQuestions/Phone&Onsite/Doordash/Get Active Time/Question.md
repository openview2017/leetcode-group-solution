# Get Active Time  

**Reference:**   
(https://leetcode.com/discuss/interview-question/1302606/DoorDash-onsite-interview-(new-question!))  
Given a sequence of timestamps & actions of a dasher's activity within a day, we would like to know the active time of the dasher.   Idle time is defined as the dasher has NO delivery at hand. (That means all items have been dropped off at this moment and the dasher is just waiting for another pickup) Active time equals total time minus idle time. Below is an example. Dropoff can only happen after pickup. 12:00am means midnight and 12:00pm means noon. All the time is within a day.

~~~
Timestamp(12h) | Action
8:30am | pickup
9:10am | dropoff
10:20am| pickup
12:15pm| pickup
12:45pm| dropoff
2:25pm | dropoff
~~~
total time = 2:25pm-8:30am = 355 mins;  
idle time = 10:20am-9:10am = 70 mins;  
active time = total time-idle time = 355-70 = 285 mins;  