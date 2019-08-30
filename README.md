# spring-cloud-beginner
The Beginner’s Guide To Spring Cloud - Ryan Baxter -  https://www.youtube.com/watch?v=aO3W-lYnw-o

### About The Apps

#### Name App
The `name` app will return the value of the `name` property when making an HTTP `GET` request to `/`.

#### Greeting App
The `greeting`app returns a greeting.  You can make a GET request to `/` and it will return `Hello`.  You can also make an HTTP `GET`
and pass a language code to return a greeting for that language.  For example a `GET` to `/es` would return `Hola`.

#### Web App
The `web` app makes a request to both the `greeting` and `name` app to construct the proper greeting when you make a `GET` to `/`.
By changing the `Accept-Language` header you can change the language of the greeting returned.  For example if you set the `Accept-Language` header to `de` the greeting returned will be `Hallo Ryan`.

## Steps
* start eureka, configserver, zipkin from config directory i.e. 
    * cd to config dir, then run:
        * spring cloud eureka configserver zipkin

Couldn't get zipkin to register with eureka - but didnt matter in overall context
    
* then start the 3 services i.e. web, greeting, name (run them through vscode)

* access them on
    * eureka - http://localhost:8761
    * zipkin - http://localhost:9411/zipkin/
    * configserver - http://localhost:8888/greeting/default
    * the app. itself - http://localhost:8080/
        * with zuul proxy - can go to http://localhost:8080/greeting or http://localhost:8080/name, proxying through web service to greeting service