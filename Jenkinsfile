node {
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
