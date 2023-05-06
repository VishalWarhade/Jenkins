pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                git branch: 'main', url: 'https://github.com/VishalWarhade/Jenkins.git'
            }
        }
        stage ('build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage ('test') {
            steps {
                echo 'test successs'
            }
        }
        stage ('deploy') {
            steps {
                echo 'deploy successs'
            }
        }
    }
}