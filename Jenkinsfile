pipeline {
    agent any
    tools { maven 'Maven3' }
    options { timestamps() }

    stages {
        stage('Build') {
            steps { sh 'mvn -B clean compile' }
        }
        stage('Unit Tests') {
            steps { sh 'mvn -B test' }
            post { always { junit 'target/surefire-reports/*.xml' } }
        }
        stage('Integration Tests') {
            steps { sh 'mvn -B verify' }
            post { always { junit 'target/failsafe-reports/*.xml' } }
        }
        stage('Empaquetar Artefacto') {
            steps {
                sh 'mvn -B package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
    post {
        success { echo 'Pipeline CI OK.' }
        failure { echo 'El pipeline fallo.' }
    }
}