
/*
// Simple Jenkins file with email notification
pipeline {
    agent any

    stages 
    {
        stage('Unit Test') 
        {
            steps 
            {
                echo 'Unit App'
            }
        }
        stage('Build') 
        {
            steps 
            {
                echo 'Build App'
            }
        }


        stage('Test') 
        {
            steps 
            {
                echo 'Test App'
            }
        }

        stage('Deploy') 
        {
            steps 
            {
                echo 'Deploy App'
            }
        }
    }

    post
    {
        always
        {
                    emailext body: '''This is Jenkins Pipeline
        ''', subject: 'Pipeline Status: ${JOB_NAME}-${BUILD_NUMBER}', to: 'automatesmb100@gmail.com'
        }

        failure
        {
            emailext body: '''Build is failed due to some reason
''', subject: 'Failed Pipeline Status: ${JOB_NAME}-${BUILD_NUMBER}', to: 'automatesmb100@gmail.com'
        } 
    }
}
*/


// Jenkins File With Maven and git used 

pipeline {
    agent any

    tools {
        
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/ravilohana/MavenJenkins.git'
                bat "mvn -Dmaven.test.failure.ignore=true -DBrowser=chrome clean package"
            }

            post {
                    success {
                        junit '**/target/surefire-reports/TEST-*.xml'
                        archiveArtifacts 'target/*.jar'
                        emailext body: '''This is Jenkins Pipeline
            ''', subject: 'Pipeline Status: ${JOB_NAME}-${BUILD_NUMBER}', to: 'automatesmb100@gmail.com'
                    }

                    failure
                    {
                        emailext body: '''Build is failed due to some reason
            ''', subject: 'Failed Pipeline Status: ${JOB_NAME}-${BUILD_NUMBER}', to: 'automatesmb100@gmail.com'
                    } 
    }
            }
        }
}

