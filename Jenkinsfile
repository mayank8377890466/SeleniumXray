pipeline {
    // master executor should be set to 0
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
			bat "docker-compose down"

		}
	}
}