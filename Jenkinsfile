pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
				bat 'gradlew jar --info'
            }
    }
		stage('Doc') {
			steps {
				echo 'Documenting..'
				bat 'gradlew javadoc --info'
			}
		}
    stage('Unit Test') {
      steps {
        echo 'Testing..'
			  bat 'gradlew test --info'
       }
     }
     stage('Deploy') {
       steps {
         echo 'Deploying....'
       }
     }
}
