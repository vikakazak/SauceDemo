pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('GIT clone') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/vikakazak/SauceDemo.git'

            }

        }
        stage('Test') {
            steps {

                // To run Maven on a Windows agent, use
                bat "mvn clean test"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts '**/target/surefire-reports/TEST-*.xml'
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
