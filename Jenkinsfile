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
                bat 'docker build -t mohamed224/book-store:1.0.1 .'
            }
        }

        stage("Push docker image"){
            steps{
                withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
                         bat "docker login -u mohamed224 -p ${dockerHubPwd}"
                       }
                   bat 'docker push mohamed224/book-store:1.0.1'
           }
        }

        stage("Run container"){
            steps{
                  bat 'docker run -p 9090:9090 -d --name book-store mohamed224/book-store:1.0.1'
            }
          }

    }
}
