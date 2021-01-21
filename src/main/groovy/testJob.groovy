def execute() {
   node() {

           stage("test") {
                   sh "echo 'Hello world!'";
                   echo  "Hello!"
               }
           
       
   }
}

return this