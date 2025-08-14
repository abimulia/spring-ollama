# Spring AI with Ollama

[![Spring Boot v3.5.4](https://img.shields.io/badge/Java-SpringBoot-green)](https://spring.io/)
[![Spring AI 1.0.1](http://img.shields.io/:AI-SpringAI-orange.svg)](https://docs.spring.io/spring-ai/reference/index.html)
[![Ollama](http://img.shields.io/:LLM-Ollama-brown.svg)](https://ollama.com/)
[![License](http://img.shields.io/:license-Apache-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

Spring AI project to access local LLM Ollama to accept NLP request.
Integrate to Weather API to get the current weather  
This project inspired by *Dan Vega* tutorial [Getting Started with Ollama, Llama 3.1 and Spring AI](https://www.youtube.com/watch?v=dffEF9ORVUg&t=879s), with the changes to adapt to new Spring AI 1.0.1 and Spring Boot 3.5.4  

- Spring Boot 3.5.4
- Spring AI 1.0.1 + Ollama (model llama3.1)
- ToolCallback
- WebClient (non-blocking)
- WeatherConfigProperties 

## How to Run
### Ollama
Make sure Ollama running
```
C:\Users\abimu>ollama list
NAME               ID              SIZE      MODIFIED
llama3.1:latest    46e0c10c039e    4.9 GB    13 hours ago
gpt-oss:20b        aa4295ac10c3    13 GB     14 hours ago

C:\Users\abimu>ollama run llama3.1
>>> Send a message (/? for help)
```

### Set environment variable for API Key
```
setx WEATHER_API_KEY YOUR_KEY_HERE   # Windows
or
export WEATHER_API_KEY=YOUR_KEY_HERE # macOS/Linux
```
### Run the Application
```
mvn spring-boot:run
```
<img width="1427" height="732" alt="Image" src="https://github.com/user-attachments/assets/776673a1-20d9-425f-a61a-6333532673ef" />

### Test the Application
```
curl "http://localhost:8080/city/ask?message=bagaimana cuaca kota jakarta hari ini?"
```
<img width="843" height="329" alt="Image" src="https://github.com/user-attachments/assets/36ee9edc-b897-4425-b3c0-b07302773f51" />  

<img width="1427" height="732" alt="Image" src="https://github.com/user-attachments/assets/7a766244-e768-4f9d-bf99-2d5bdc693345" />  

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.4/maven-plugin)
* [Ollama](https://ollama.com/)
* [Chat Ollama](https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.4/reference/web/servlet.html)
* [Spring AI](https://docs.spring.io/spring-ai/reference/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
