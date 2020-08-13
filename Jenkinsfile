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

        stage("Angular project"){
            steps{
                dir("${env.WORKSPACE}/bookstore-client/src"){
                    bat 'npm start'
                }
            }
        }

    }
}
