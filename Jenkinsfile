pipeline{
    agent any

    stages{
        stage("build"){
            steps{
               bat 'mvn clean package'
            }
        }

        stage("test"){
            steps{
                bat 'mvn test'
            }
        }

    }
}
