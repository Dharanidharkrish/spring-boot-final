def call(String msg = 'Sonar Qube'){
  echo "${msg}"
  withSonarQubeEnv('sonarqube'){
                     sh 'mvn sonar:sonar'
                }
}
