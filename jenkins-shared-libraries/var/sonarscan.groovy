def analyze(String projectKey, String branch = 'main') {
    withSonarQubeEnv('SonarQube') {
        sh """
        sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.sources=. \
            -Dsonar.host.url=${env.SONAR_HOST_URL} \
            -Dsonar.login=${env.SONAR_AUTH_TOKEN} \
            -Dsonar.branch.name=${branch}
        """
    }
}
