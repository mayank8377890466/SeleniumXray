pipeline {
    // master executor should be set to 0
    agent any
    stages {
		stage("Start Grid"){
			steps{
				bat "docker-compose up -d hub_1 chrome firefox"
			}
		}
		stage("Run Test"){
			steps{
				bat "mvn clean test"
			}
		}
	}
	post{
		always{
		    archiveArtifacts artifacts: 'Reports/ExecutionReport.html', followSymlinks: false
		    junit 'target / surefire-reports /*.xml'
			bat "docker-compose down"
		}
	}
}