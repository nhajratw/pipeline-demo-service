pipeline {
  agent any
  environment {
    releaseVersion = "1.0.$BUILD_NUMBER"
  }
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
    stage('micro tests'){
      steps{
        sh "$WORKSPACE/gradlew test"
      }
    }
    stage('integration tests') {
      steps {
        sh "$WORKSPACE/gradlew integrationTest"
      }
    }
    stage('artifacts'){
      steps{
        sh "$WORKSPACE/gradlew assemble -Pversion=$releaseVersion"
      }
    }
    stage('publish') {
      steps {
        sh "$WORKSPACE/gradlew publish -Pversion=$releaseVersion"
      }
    }
  }
}
