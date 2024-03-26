# sanitas Test API
This application uses:
1. Maven build tool V. 3.8.1
2. Spring Boot V. 3.2.1
3. Unit Test with MockMvc
4. Open API (Swagger) documentation
5. Spring Actuator
6. Docker

# How to run it?

- execute in 'folder': 
```bash
git clone https://github.com/andresrolo123/sanitasTest.git 
```
- get 'folder' branch:
```bash
git checkout develop
```
- move to 'folder' and execute: 
```bash
mvn clean install
```
- execute: 
```bash
docker build -t sanitastest:latest .
```
- execute: 
```bash
run -p 8080:8080 -t sanitastest
```
# How to verify it?

Access to Actuator URL
```bash
http://localhost:8080/actuator/health
```
Access the Swagger URL
```bash
http://localhost:8080/swagger-ui.html
```
### Request Example
```bash
curl -X GET "http://localhost:8080/api/calculator/addNumbers?num1=1&num2=5" -H "accept: */*"
```
### Response Example
```bash
6
```

# Could we improve it?
Definitly yes! We could add different tests (mutation, ITs, more UTs), validations, implement persistence layer and more. We could discuss it

