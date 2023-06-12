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
               sh '/opt/apache-maven/bin/mvn sonar:sonar  -Dsonar.projectKey=student_app  -Dsonar.host.url=http://52.69.18.186:9000  -Dsonar.login=8bb01e8e273d20974b7166358dc3351f848e9f9a'
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