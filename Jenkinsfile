pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                echo 'application build...'
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './gradlew check'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
    
    post {
        always {
            archive 'build/libs/**/*.jar'
            junit 'build/reports/**/*.xml'
        }
    }
}
