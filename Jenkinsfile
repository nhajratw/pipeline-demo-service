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
        git url:'/Users/nayan/Documents/workspace/pipeline-demo/pipeline-demo-service', branch:'goat17'
      }
    }

    stage('micro tests') {
      steps {
        sh "$WORKSPACE/gradlew test"
      }
    }
  }
}
