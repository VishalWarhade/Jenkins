pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                git 'https://github.com/shubhamkalsait/studentapp-ui'
            }
        }
        stage ('build') {
            steps {
                sh '/opt/apache-maven/bin/mvn clean package'
            }
        }
        stage ('test') {
            steps {
                sh '/opt/apache-maven/bin/mvn sonar:sonar \ -Dsonar.projectKey=studentapp \ -Dsonar.host.url=http://43.207.194.247:9000 \ -Dsonar.login=7d1f21bd14af328742a92f93536c616ae8bc5b4c'
            }
        }
        stage ('deploy') {
            steps {
                echo 'deploy successs'
            }
        }
    }
}
//https://github.com/shubhamkalsait/studentapp-ui 