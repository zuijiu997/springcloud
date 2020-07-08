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
                sh "docker build -t zuijiu997/springcloud:${params.VERSION} ."
                sh "docker login -u zuijiu997 -p zuijiu997"
                sh "docker push zuijiu997/springcloud:${params.VERSION}"
            }
        }

        stage("deploy") {
            kubernetesDeploy configs: 'deploy.yaml', deleteResource: true, dockerCredentials: [[credentialsId: 'zuijiu997']], kubeConfig: [path: ''], kubeconfigId: '', secretName: '', secretNamespace: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
        }

    }
}