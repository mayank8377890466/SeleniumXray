pipeline {
    //master executor should be set to 0
    agent any
   parameters {
     choice choices: ['chrome', 'firefox', 'edge', 'grid','chromelinux'], description: 'Select a browser', name: 'browser'
     string defaultValue: 'http://10.0.2.15:4444/wd/hub', description: 'Enter grid hub url', name: 'grid_hub'
     choice choices: ['methods', 'classes', 'tests','none'], description: 'Select parallel ', name: 'parallel'
     string defaultValue: '0', description: 'Enter thread count', name: 'threadcount'
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
				sh "mvn clean test -Dbrowser='${params.browser}' -Dgrid_hub='${params.grid_hub}' -Dparallel='${params.parallel}' -Dthreadcount='${params.threadcount}'"
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