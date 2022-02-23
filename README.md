# spring-testcontainer-demo

![sring-testcontainer-demo](https://github.com/kdima90/spring-testcontainer-demo/actions/workflows/github-actions.yml/badge.svg)

This small project is about, how to configure spring boot app with testcontainers.

To run the app, at fist run the postgres container. To do so run docker-compose.yml included in the project. Just `docker-compose up -d` and run spring-testcontainer-demo via maven's spring boot plugin (`mvn spring-boot:run`) or via your preferred IDE.