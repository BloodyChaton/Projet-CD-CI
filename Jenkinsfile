pipeline{
  agent {
    label 'linux'
  }
  environment{
    MONGODB_ADMIN_USER='yacuba'
    MONGODB_ADMIN_PWD='yacuba'
    MONGODB_URL='192.168.60.4'
    MONGODB_PORT='27017'
  }
  tools{
    maven 'mavenslave'
  }
  stages {
    stage ('checkout'){
      steps{
          git branch: 'features/luc', credentialsId: 'GitHubCDCI', url: 'https://github.com/BloodyChaton/Projet-CD-CI.git'
        }
    }
    // stage ('set-up env variable') {
    //   steps{
    //     sh "./env.sh"
    //     sh "echo $MONGODB_ADMIN_USER"
    //   }
    // }
    stage ('validate'){
      steps{
        sh "mvn validate"
      }
    }
    stage ('test'){
      parallel{
        try{
          stage ('etape-1.1') {
            steps {    
              sh "mvn test"
            }
          }
        } catch (Exception e) {
          echo "Stage failed, let's continue the build though"
        }
        stage ('etape-1.2') {
          steps {
            sh "mvn pmd:pmd"
          }
        }
      }
    }
    // stage ('deploy'){
    //   steps{
    //     sh "mvn deploy -DskipTests"
    //   }
    // }
  }
}
