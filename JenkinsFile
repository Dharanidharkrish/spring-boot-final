pipeline {
libraries{
lib 'shlib'
lib 'shlib@sonar.groovy'
lib 'shlib@build.groovy'
lib 'shlib@nexus.groovy'
lib 'shlib@gate.groovy'
lib 'shlib@devenvironment.groovy'
lib 'shlib@deploy_dev.groovy'
lib 'shlib@deploy_ansible.groovy'
}

 agent any
   tools{
        maven "Maven"
    }
    stages {
      stage('Start')
            {
                steps
                 { 
                    sendNotifications 'STARTED'
                 }
            }

      stage('clean and build')
            {
                steps{
                    
                sendNotifications 'STARTEDBUILD'
                build 'BUILD'
                 
            }
            }
            
                
                 
             stage('SonarQube analysis') {
             environment {
           scannerHome=tool 'sonarScanner'
       }

            steps {
            sendNotifications 'SONAR ANALYSIS STARTED'
                withSonarQubeEnv('SonarQube'){
                     sh 'mvn sonar:sonar'
                }
            } 
            }
        stage('Quality Gate') {
            steps {
             gate 'GATE'
            }
       }
  
            stage("nexus") {
            steps {
          sendNotifications  'NEXUS STAGE STARTED'
          nexus 'NEXUS'
        }
        }
         stage('Deploy to Development'){
            steps{
            devenvironment 'DEPLOY INTO DEV ENVIROINMENT'
             deploy_development 'deploy_dev'
            }
        }
        stage('Deploy to Ansible Master'){
            steps{
               sendNotifications 'Deploy to Ansible Master'
               deploy_ansible  'deploy_ansible'
            } 
        }
        
        stage('Approval1'){
                steps{
                approval 'APPROVAL'
                }
                }
                
        stage('Deploy to Test Server'){
             steps{
                 sendNotifications 'Deploy to Test Server'
                 deploy_test 'deploy_test'
             }
        }
        
        stage('Approval2'){
                steps{
                approval 'APPROVAL'
                }
                }
        stage('Deploy to Performance Server'){
             steps{
             sendNotifications 'Deploy to Performance Server'
                 deploy_performance 'deploy_per'
             }
        }
        stage('Approval3'){
                steps{
                approval 'APPROVAL'
                }
                }
        stage('Deploy to Production Server'){
             steps{
             sendNotifications 'Deploy to Production Server'
                 deploy_production  'deploy_prod'
             }
        }

      
        }
        post{
always{
sendNotifications currentBuild.result
}
}

    }
