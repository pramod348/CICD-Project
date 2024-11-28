// vars/sonarQubeIntegration.groovy
def call() {
    // Check if SonarQube URL and Token are available
    if (!env.SONAR_URL || !env.SONAR_TOKEN) {
        error "SONAR_URL and SONAR_TOKEN must be defined in the .env file"
    }

    // Configure the SonarQube scanner for Jenkins
    withEnv(["SONAR_HOST_URL=${env.SONAR_URL}", "SONAR_LOGIN=${env.SONAR_AUTH_TOKEN}"]) {
        // Run the SonarQube scan using Maven (or adjust based on your build tool)
        sh """
            mvn clean install sonar:sonar \
            -Dsonar.projectKey=${env.SONAR_PROJECT_KEY} \
            -Dsonar.projectName=${env.SONAR_PROJECT_NAME} \
            -Dsonar.host.url=${env.SONAR_URL} \
            -Dsonar.login=${env.SONAR_TOKEN}
        """
    }
}
