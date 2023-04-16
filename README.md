# Weather backend

### Project
Simple Gradle-Kotlin based backend implementing a RESTful API

### Requirements
* Java 17
* Gradle

### Usage
Build using `gradle build`

### Business logic
The application receives a **/forecast/get** HTTP GET request and invokes the Open Meteo API to retrieve weather information for a given location.

### Samples

Request:
http://localhost:8080/forecast/get?lat=41.47492&long=2.06185

Response:
```json
{
    "latitude": 41.47,
    "longitude": 2.0599995,
    "timezone": "GMT",
    "elevation": 163.0,
    "temperature": 19.6,
    "windspeed": 21.7,
    "winddirection": 192.0,
    "time": "2023-04-16T15:00"
}
```