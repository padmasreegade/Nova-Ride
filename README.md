# 🚍 Nova Ride - Faster, Smarter

Nova Ride is a real-time university shuttle tracking system developed as part of an independent study project. It allows students to view shuttle movement on a map, estimate arrival times at stops, and get walking directions from their current location to the nearest stop.

The application is split into three components:
#### 1. A driver-side Android app
#### 2. A Spring Boot REST API backend
#### 3. A web frontend to visualize shuttle movement and provide real-time guidance to users

#### Project Stucture
```
NovaRide/
├── app/                                     # Android app for drivers
├── src/                                     # Spring Boot backend exposing /location API
├── src/main/resources/templates             # Web frontend to track shuttle
└── README.md                                # This file
 ```

#### Working

##### 1. Android App (Driver Device)

- Installed on the shuttle driver's Android device
* Requires:
  - Internet access
  + Location permissions:
      - ACCESS_FINE_LOCATION – for static/initial location
      + ACCESS_COARSE_LOCATION – for dynamic real-time tracking
+ Continuously provides GPS coordinates to the backend service

#### 2. Spring Boot Backend (API Service)

- Exposes REST API endpoint: GET /location
* Fetches the initial location from the Android app
+ Responds with a JSON object containing:
  ```
  {
  "latitude": 40.0366,
  "longitude": -75.3410
  }
  ```
#### 3. Web Frontend 

- Provides an interactive map to:
  - Display shuttle movement in real time
  * Highlight shuttle route based on a configurable list of stops
  * Show ETA (Estimated Time of Arrival) at each stop (based on university-provided schedule)
  + Offer directions from the user’s current location to the nearest stop via a top-right panel

#### Technologies Used

- ###### Layer	        Technology
* Android App	          Java/Kotlin, Android SDK
* Backend API	          Spring Boot, Java, REST, WebClient
+ Web Frontend	        HTML, CSS, JavaScript, Thymeleaf, Leaflet, OSRM

#### Getting Started

##### Android App
- Import app/ into Android Studio Meerkat
* Build and run on a physical Android device with location services enabled
* Grant necessary permissions
- Keep the app running in the background

##### SpringBoot Application
```
./mvnw spring-boot:run
```

#### Web Frontend
- After running the springboot app, access ```http://<baseurl>:<port>/map```
