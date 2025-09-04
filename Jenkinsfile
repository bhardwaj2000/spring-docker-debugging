pipeline {
    agent any
    tools{
        maven 'maven_3_9_11'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/bhardwaj2000/spring-docker-debugging']]])
                bat 'mvn clean install'
            }
        }
    }
}