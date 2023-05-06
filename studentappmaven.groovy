pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                git 'https://github.com/VishalWarhade/studentapp.git'
            }
        }
        stage ('build') {
            steps {
                sh '/opt/apache-maven/bin/mvn clean package'
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