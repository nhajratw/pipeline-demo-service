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
    stage('tests'){
      steps {
        sh "testVar='nayan'"
        sh "$WORKSPACE/gradlew test"
        sh "$WORKSPACE/gradlew integrationTest"
        sh "echo $testVar"
      }
    }
  }
}
