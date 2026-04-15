pipeline {
    agent any

    tools {
        jdk 'JDK'
    }

    environment {
        PATH = "/usr/local/bin:${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/spandana7803/MyGradleSeleniumApp.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Run Selenium') {
            steps {
                sh './gradlew run'
            }
        }
    }

    post {
        success {
            echo 'Build & Test Successful ✅'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}
