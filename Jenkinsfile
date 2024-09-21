pipeline {
    agent any 
    tools {
        maven "Maven_3.9.6"
    }
    stages {
        stage('Compile and Clean') { 
            steps {
                // Run Maven to clean and compile the Kafka Spring Boot application
                sh "mvn clean compile"
            }
        }
        stage('Package') { 
            steps {
                // Package the application (including tests)
                sh "mvn package"
            }
        }
        stage('Build Docker image') {
            steps {
                echo "Building Docker image for springboot-kafka-demo"
                sh 'ls'
                sh 'docker build -t  chtseng93/springboot-kafka-demo:${BUILD_NUMBER} .'
            }
        }
        stage('Docker Login') {
            steps {
                withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u chtseng93 -p ${Dockerpwd}"
                }
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker push chtseng93/springboot-kafka-demo:${BUILD_NUMBER}'
            }
        }
        stage('Docker Deploy') {
            steps {
                // Deploy the application with Kafka integration
                sh 'docker run -itd -p 8089:8089 chtseng93/springboot-kafka-demo:${BUILD_NUMBER}'
            }
        }
        stage('Archiving') {
            steps {
                // Archive the built JAR
                archiveArtifacts '**/target/*.jar'
            }
        }
    }
}
