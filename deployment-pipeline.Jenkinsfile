pipeline {
    agent any
    tools { maven 'Maven3' }
    environment {
        VERSION     = "build-${env.BUILD_NUMBER}"
        STAGING_URL = "https://staging.miapp.local"
    }
    stages {
        stage('Build & Empaquetar') {
            steps {
                sh 'mvn -B clean package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
        stage('Acceptance Test Gate') {
            steps {
                sh './infra/deploy-bluegreen.sh green ${VERSION}'
                sh 'mvn -B verify -Dacceptance=true -Dstaging.url=${STAGING_URL}'
            }
        }
        stage('Switch a Produccion (Blue-Green)') {
            steps { sh './infra/deploy-bluegreen.sh switch green' }
        }
    }
    post {
        failure {
            echo "Fallo detectado: ejecutando ROLLBACK"
            sh './infra/rollback.sh'
        }
        success { echo "Despliegue completado y verificado." }
    }
}