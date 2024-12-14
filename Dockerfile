##artifact build stage
FROM docker.io/library/maven:3.8 AS buildstage
RUN mkdir /opt/mindcircuit13
WORKDIR /opt/mindcircuit13
COPY . .
RUN mvn clean install    ## artifact -- .war

### tomcat deploy stage
FROM docker.io/library/tomcat
WORKDIR webapps
COPY --from=buildstage /opt/mindcircuit13/target/*.war .
RUN rm -rf ROOT && mv *.war ROOT.war
EXPOSE 8080
