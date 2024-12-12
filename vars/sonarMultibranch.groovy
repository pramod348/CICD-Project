// vars/sonarQubeIntegration.groovy

def call() {
    // Perform SonarQube scanning using the environment variables
    withEnv([
        "SONARQUBE_HOST_URL=${env.SONARQUBE_HOST_URL}",
        "SONARQUBE_PROJECT_KEY=${env.SONARQUBE_PROJECT_KEY}",
        "SONARQUBE_AUTH_TOKEN=${env.SONARQUBE_AUTH_TOKEN}"
    ]) {
        sh '''
            sonar-scanner \
                -Dsonar.projectKey=$SONARQUBE_PROJECT_KEY \
                -Dsonar.host.url=$SONARQUBE_HOST_URL \
                -Dsonar.login=$SONARQUBE_AUTH_TOKEN
        '''
    }
}
