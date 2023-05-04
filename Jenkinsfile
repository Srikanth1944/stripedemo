pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build App'
            }
        }
       
        stage('Deploy') {
            steps {
                echo 'Deploy App'
            }
        }
    }
    post{
        always{
            emailext body: 'Summery', subject: 'Pipline jenkins', to: 'srinimmala916@gmail.com'
        }
    }
}
