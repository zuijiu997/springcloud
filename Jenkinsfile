def label = "jnlp-agent"

podTemplate(label: label,cloud: "kubernetes" ){
    node (label) {
        stage('Git阶段'){
            git branch: "master",url: "https://github.com/zuijiu997/springcloud.git"
        }

        stage('mvn阶段'){
            container('ubuntu-build') {
                sh "mvn clean package"
            }
        }

        stage('docker'){
            container('ubuntu-build') {
                 //withDockerRegistry(credentialsId: '3f061478-979f-41be-8990-d081ff1002e9') {
                 //   sh "docker build -t zuijiu997/springcloud:${params.VERSION} ."
                 //   sh "docker push zuijiu997/springcloud:${params.VERSION}"
                 //}

                 sh "docker build -t zuijiu997/springcloud:${params.VERSION} ."
                 sh "docker login -u zuijiu997 -p zuijiu997"
                 sh "docker push zuijiu997/springcloud:${params.VERSION}"
            }
        }

        stage("deploy") {
             kubernetesDeploy(kubeconfigId: '754a1850-8415-4acb-b775-3ae8f52de89e',               // REQUIRED
                  configs: 'deploy.yaml', // REQUIRED
                  enableConfigSubstitution: false,
             )
        }

    }
}