pipeline {
    agent none
    environment {
        ENV_NAME = "${env.BRANCH_NAME}"
    }
    stages {
        stage('Initialize') {
            def dockerHome = tool 'docker-desktop'
            env.PATH = "${dockerHome}/bin:${env.PATH}"
        }
        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                script {
                      // vinsdocker/containertest => organization/application - it could be anything
                      app = docker.build("jdcbogar/cucumbercontainer")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        app.push("${BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }        
    }
}
