// vars/sonarQubeIntegration.groovy
def call() {
    // Ensure SonarQube environment variables are set from the .env file
    withSonarQubeEnv('SonarQube') {
        // Run the SonarQube analysis
        sh 'mvn clean install sonar:sonar -Dsonar.login=${SONAR_TOKEN}'
    }
}
