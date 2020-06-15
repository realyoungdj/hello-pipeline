pipeline {
    agent any

    stages {
        stage('PreBuild') {
            steps {
                sh 'echo hello'
                sh 'mvn --version'
                sh 'env'
            }
        }
        stage('PreBuild 2') {
            steps {
                sh 'pwd'
                sh 'who'
            }
        }
        stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn package -DskipTest=true'
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: '83e53922-fa50-4c02-8dc8-faee8ec964ae', path: '', url: 'http://localhost:9090')], contextPath: null, war: 'target/hello-pp.war'
            }
        }
        stage('After Deploy') {
            steps {
                emailext body: '$DEFAULT_CONTENT', subject: '$DEFAULT_SUBJECT', to: 'dev@djxy.de'
            }
        }
    }
}
