pipeline {

    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven-3.8.7'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('app/springboot-app') {
                    sh 'mvn clean package'
                }
            }
        }

    }

    post {
        always {
            echo 'Pipeline Finished'
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}