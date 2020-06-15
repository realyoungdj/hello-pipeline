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
    }
}
