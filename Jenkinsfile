pipeline{
  agent {
    label 'linux'
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
    stage ('set-up env variable') {
      steps{
        sh "./env.sh"
        sh "echo $MONGODB_ADMIN_USER"
      }
    }
    stage ('validate'){
      steps{
        sh "mvn validate"
      }
    }
    stage ('test'){
      parallel{
        stage ('etape-1.1') {
          steps {    
            sh "mvn test"
          }
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
