node {
   stage('Git checkout') { // for display purposes
        git 'https://github.com/BushnevYuri/e2e-automation-pipeline.git'
   }
   stage('Test') {
        try {
            sh "mvn clean install"
        } catch (err) {
            
        }
   }
   stage('Results') {
      junit '**/target/failsafe-reports/*.xml'
   }
}
