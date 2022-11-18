pipeline {
    agent any

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'main', name: 'BRANCH', type: 'PT_BRANCH'
        }

    tools {
        maven "M3"
        }

    triggers {
        cron('0 21 * * 5')
    }

    stages {
        stage('Build') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/Sentelzzz/training_senla.git'

            }
        }

        stage('Run test'){
            steps {
                bat "mvn -Dmaven.test.failure.ignore=true -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml clean test package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Allure report') {
                        steps {
                            script {
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

