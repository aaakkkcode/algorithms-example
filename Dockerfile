FROM gcr.io/distroless/java:11
CMD [ "/opt/app.jar" ]
EXPOSE 8080
COPY libs/*.jar /opt/app.jar
