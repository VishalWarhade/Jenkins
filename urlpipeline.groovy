pipeline {
    agent any
    stages {
        stage ('clone') {
            steps {
                git 'https://github.com/VishalWarhade/Jenkins.git'
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