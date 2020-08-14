pipeline{
    agent any

    stages{
        stage("build"){
            steps{
               bat 'mvn clean package -DskipTests'
            }
        }

        stage("test"){
            steps{
                bat 'mvn test'
            }
        }

        stage("Build docker image"){
            steps{
                bat 'docker build -t mohamed224/book-store:1.0.0 .'
            }
        }

        stage("Push docker image"){
            steps{
                withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
                         bat "docker login -u mohamed224 -p ${dockerHubPwd}"
                       }
                   bat 'docker push mohamed224/book-store:1.0.0'
           }
        }

    }
}
