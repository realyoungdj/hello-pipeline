void setBuildStatus(String message, String state) {
  step([
      $class: "GitHubCommitStatusSetter",
      reposSource: [$class: "ManuallyEnteredRepositorySource", url: env.GIT_URL],
      contextSource: [$class: "ManuallyEnteredCommitContextSource", context: "ci/jenkins/build-status"],
      errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      statusResultSource: [ $class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]] ]
  ]);
}

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
                deploy adapters: [tomcat9(credentialsId: '226f4898-b921-4d18-a796-66b90361e4ca', path: '', url: 'http://localhost:9090')], contextPath: null, war: 'target/hello-pp.war'
            }
        }
        stage('After Deploy') {
            steps {
                emailext body: 'test', subject: 'sub', to: 'dev@djxy.de'
            }
        }
    }
    post {
        success {
            setBuildStatus("Build succeeded", "SUCCESS");
        }
        failure {
            setBuildStatus("Build failed", "FAILURE");
        }
    }
}
