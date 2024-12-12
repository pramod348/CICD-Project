##artifact build stage
FROM docker.io/library/maven:3.8 AS buildstage
RUN mkdir /opt/pramod
WORKDIR /opt/pramod
COPY . .
RUN mvn clean install    ## artifact -- .war

### tomcat deploy stage
FROM docker.io/library/tomcat
WORKDIR webapps
COPY --from=buildstage /opt/pramod/target/*.war .
RUN rm -rf ROOT && mv *.war ROOT.war
EXPOSE 8080
