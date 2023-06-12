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
               sh  '/opt/apache-maven/bin/mvn clean package'
            }
        }
        stage ('test') {
           steps {
               sh '/opt/apache-maven/bin/mvn sonar:sonar  -Dsonar.projectKey=studentapp  -Dsonar.host.url=http://18.181.176.168:9000  -Dsonar.login=716198d6d5ba0a952744e4c2a3a47bf013b5e120'
           }
       }

        // stage ('test') {
        //     steps {
        //          withSonarQubeEnv(installationName: 'sonar-server', credentialsId: 'sonar-token') {
        //             sh ' /opt/apache-maven/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp' 
        //         }
        //     }
        // }
        // stage('quality-gate'){
        //     steps {
        //         timeout(time: 1, unit: 'HOURS') {
        //             waitForQualityGate abortPipeline: true                    
        //             }
        //     }
        // }
        stage ('deploy') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'tomcat-token', path: '', url: 'http://43.207.73.18:8080')], contextPath: '/', war: '**/*.war'
            }
        }
    }
}