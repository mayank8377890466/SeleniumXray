pipeline {
    // master executor should be set to 0
    agent any
   parameters
   {
   string description: 'select your browser', name: 'browser'
   }
    stages {
    stage("SonarQube Analysis"){
             steps{
               withSonarQubeEnv("sonarqube"){
                   sh "mvn sonar:sonar"
               }
              }
          }
	  stage("Start Grid"){
			steps{
				sh "docker-compose up -d hub_1 chrome firefox"
			}
		}
		stage("Run Test"){
			steps{
				sh "mvn clean test -Dbrowser='${params.browser}'"
			}
		}
	}
	post{
		always{
	        jacoco()
		    archiveArtifacts artifacts: 'Reports/ExecutionReport.html', followSymlinks: false
		    junit 'target/surefire-reports/*.xml'
			sh "docker-compose down"
		}
	}
}