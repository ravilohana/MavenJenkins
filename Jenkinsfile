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
