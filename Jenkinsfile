pipeline {
    //master executor should be set to 0
    agent any
   parameters {
     choice choices: ['chrome', 'firefox', 'edge', 'grid'], description: 'Select a browser', name: 'browser'
     string defaultValue: 'http://10.0.2.15:4444/wd/hub', description: 'Enter grid hub url', name: 'grid_hub'
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
				sh "mvn clean test -Dbrowser='${params.browser}' -Dgrid_hub='${params.grid_hub}'"
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