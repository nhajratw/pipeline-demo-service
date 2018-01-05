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
    stage('deploy a') {
      steps {
        sh """
          cf login -a api.local.pcfdev.io --skip-ssl-validation -u admin -p admin -o demo -s pipeline-demo
          cf unmap-route pipeline-demo-service-a local.pcfdev.io --hostname pipeline-demo-service
          cf push pipeline-demo-service-a -p $WORKSPACE/build/libs/pipeline-demo-service-${releaseVersion}.jar

          if [ `curl -s -o /dev/null -w '%{http_code}' http://pipeline-demo-service-a.local.pcfdev.io/health` == 503 ] ; then exit 1; fi

          cf map-route pipeline-demo-service-a local.pcfdev.io --hostname pipeline-demo-service
        """
      }
    }
    stage('deploy b') {
      steps {
        sh """
          cf login -a api.local.pcfdev.io --skip-ssl-validation -u admin -p admin -o demo -s pipeline-demo
          cf push pipeline-demo-service-b -p $WORKSPACE/build/libs/pipeline-demo-service-${releaseVersion}.jar
          cf map-route pipeline-demo-service-b local.pcfdev.io --hostname pipeline-demo-service
        """
      }
    }
  }
}
