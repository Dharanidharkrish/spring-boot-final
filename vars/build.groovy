def call(String msg='BUILD'){
   echo "${msg}"
   sh 'mvn clean package'
}
