node {
   stage('Git checkout') { // for display purposes
        git 'https://github.com/wakatuts/cucumberproject.git'
   }
   stage('Test') {
        try {
            sh "mvn clean install"
        } catch (err) {
            
        }
   }
   stage('Results') {
      junit '**/target/surefire-reports/*.xml'
   }
}
