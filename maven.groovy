pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
               git branch: 'main', url: 'https://github.com/VishalWarhade/studentapp.git'
            }
        }
        stage ('build') {
            steps {
                sh '/opt/apache-maven/bin/mvn clean package'
            }
        } 
        stage ('test') {
            steps {
                echo 'test success'
            }
        }
        stage ('deploy') {
            steps {
                echo 'deploy success'
            }
        }
    }
}