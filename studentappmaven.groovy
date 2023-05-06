pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                git branch: 'main', url: 'https://github.com/VishalWarhade/Jenkins/studentapp-ui-master.git'
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