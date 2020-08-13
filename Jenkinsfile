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

        stage("Angular project"){
            steps{
                dir("${env.WORKSPACE}/bookstore-client/src"){
                    script{
                        bat '''npm install
                             npm start
                        '''
                    }
                }
            }
        }

    }
}
