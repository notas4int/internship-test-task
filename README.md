# Test task Application
>REST API that calculates the frequency of occurrence of characters in a given string. The resulting string is sorted by descending number of occurrences of a character in a given string.
> 
## Used technologies
* **Java**
* Spring Boot
* Maven (package manager to manipulate with dependecies)
* Lombok
* JUnit5 and Mockito (for testing)

## Steps to Setup
###### To run the application, you need jdk, maven installed, and the setting system variables JAVA_HOME and MAVEN_HOME.

**1. Clone the application**

```bash
git clone https://github.com/notas4int/test-task-mail-delivery.git
```

**2. Run the app using maven**

```bash
./mvnw spring-boot:run
```

* <u>You can also run the project through IntelliJ IDEA or other IDEs</u>

The app will start running at <http://localhost:8080>

## Explore Rest APIs

### Users
| Method | Url                                 | Decription                                               | Sample Valid Request Type | 
|--------|-------------------------------------|----------------------------------------------------------|---------------------------|
| GET    | /api/v3/get-frequency/{inputString} | get character occurrence frequencies for a given string  |                           |

## Sample responses: 

##### <a>FrequencyResponse</a>
```json
{
  "frequencyOfCharacters": {
    "a": 3,
    "s": 2,
    "g": 2,
    "d": 1
  }
}
```
##### <a>ExceptionResponse</a>
```json
{
  "requestURI": "/api/v3/get-frequency/",
  "message": "The entered string cannot be empty",
  "currentTime": "2023-09-17T15:44:33.1030234"
}
```