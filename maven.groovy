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