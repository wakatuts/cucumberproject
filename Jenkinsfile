node {
   stage('Git checkout') { // for display purposes
        git 'https://github.com/wakatuts/cucumberproject.git'
   }
   stage('Test') {
        try {
            sh "mvn verify"
        } catch (err) {
            
        } finally {
            publishHTML (target: [
            reportDir: '//target/cucumber-reports',
            reportFiles: 'index.html',
            reportName: "Cucumber tests report"
            ])
        }
   }
   stage('Results') {
      junit '**/target/surefire-reports/*.xml'
   }
}
