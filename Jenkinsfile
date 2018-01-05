pipeline {
  agent any

  stages {
    stage('clean') {
      steps {
        deleteDir()
      }
    }
    stage('pull') {
      steps {
        git url:'/Users/nayan/Documents/workspace/pipeline-demo/pipeline-demo-service', branch:'il20180104'
      }
    }
    stage('microtests'){
      steps{
        sh "$WORKSPACE/gradlew test"
      }
    }
    stage('integration tests') {
      steps {
        sh "$WORKSPACE/gradlew integrationTest"
      }
    }
  }
}
