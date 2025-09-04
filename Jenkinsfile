pipeline {
    agent any
    tools{
        maven 'maven_3_9_11'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/bhardwaj2000/spring-docker-debugging']]])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker images'){
            steps{
                script{
                    bat 'docker build -t manish172000/spring-docker-debugging .'
                }
            }
        }
        stage('Push image to Hub'){
                    steps{
                        script{
                           withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                           bat 'docker login -u manish172000 -p %dockerhubpwd%'
                           }
                           bat 'docker push manish172000/spring-docker-debugging'
                        }
                    }
        }
    }
}