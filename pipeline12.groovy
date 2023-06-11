pipeline {
    agent any
    stages {
        stage ('pull') {
            steps{
                git 'https://github.com/shubhamkalsait/studentapp-ui.git'
            }
        }
        stage ('build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage ('test') {
            steps {
                echo " test success"
            }
        }
        stage ('deploy') {
            steps {
                echo "deploy success"
            }
        }

    }
}