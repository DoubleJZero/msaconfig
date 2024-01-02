pipeline {
    agent any
    environment {
        DOCKER = 'sudo docker'
    }

    stages {
        stage('Clone Repository') {
            steps {
                checkout scm
                echo 'Checkout Scm'
            }
        }

        stage('Build image') {
            steps {
                sh 'ls -al'
                sh 'chmod +x ./gradlew'
                sh './gradlew build'
                sh 'docker build -t jandb:msaconfig .'
                echo 'Build image...'
            }
        }

        stage('Remove Previous image') {
            steps {
                script {
                    try {
                        sh 'docker stop configService'
                        sh 'docker rm configService'
                    } catch (e) {
                        echo 'fail to stop and remove container'
                    }
                }
            }
        }
        stage('Run New image') {
            steps {
                sh 'docker run --name configService -d -p 8888:8888 -e USE_PROFILE=dev jandb:msaconfig'
                echo 'Run New member image'
            }
        }
    }
}