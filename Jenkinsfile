pipeline {

    agent any

    tools {
        maven 'Maven'
        jdk 'Java21'
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/DharunDd11/Jenkins-Maven.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Parallel Tests') {

            parallel {

                stage('Chrome Test') {
                    steps {
                        bat 'echo Running Chrome Tests'
                    }
                }

                stage('Firefox Test') {
                    steps {
                        bat 'echo Running Firefox Tests'
                    }
                }

            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {

        success {
            echo 'BUILD SUCCESSFUL'
        }

        failure {
            echo 'BUILD FAILED'
        }

        always {
            echo 'PIPELINE EXECUTION COMPLETED'
        }
    }
}
