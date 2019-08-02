# spring-cloud-beginner
The Beginner’s Guide To Spring Cloud - Ryan Baxter -  https://www.youtube.com/watch?v=aO3W-lYnw-o

## Steps
* start eureka, configserver, zipkin from config directory i.e. 
    * cd to config dir, then run:
        * spring cloud eureka configserver zipkin
    
* then start the 3 services i.e. web, greeting, name (run them through vscode)

* access them on
    * eureka - http://localhost:8761
    * zipkin - http://localhost:9411/zipkin/
    * configserver - http://localhost:8888/greeting/default
    * the app. itself - http://localhost:8080/