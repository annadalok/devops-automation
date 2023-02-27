pipeline {

    agent any
    tools{
        maven 'Maven_Home'
    }
     stages{
         stage('Build Maven') {
             steps {
                 checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/annadalok/devops-automation']])
                 sh 'mvn clean install'
             }
         }
         stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t anandebix/devops-integration .'
                }
            }
        }
        stage('push image to docker hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerpwd')]) {
                      sh 'docker login -u anandebix -p ${dockerpwd}'
                    }
                    sh 'docker push anandebix/devops-integration'
                }
            }
        }
     }
}