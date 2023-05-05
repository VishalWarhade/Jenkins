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
                echo 'build success'
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