def call(String msg = 'NEXUS'){
  echo "${msg}"
  withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'pass', usernameVariable: 'userId')]) {
         sh   'curl -F file=@target/myWebApp_Test-${BUILD_NUMBER}.war -u $userId:$pass gvar.nexusRepoUrl/myWebApp_Test-${BUILD_NUMBER}.war'
			   sh   'curl -F file=@target/myWebApp_Test-${BUILD_NUMBER}.war -u $userId:$pass gvar.nexusRepoUrl/myWebApp_Test-1.war'
			  } 
			  
       			}
}
