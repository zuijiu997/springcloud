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
         //   kubernetesDeploy configs: 'deploy.yaml', deleteResource: true, dockerCredentials: [[credentialsId: 'zuijiu997']], kubeConfig: [path: '/home/jenkins/agent/config'], kubeconfigId: '', secretName: '', secretNamespace: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: 'LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUN5RENDQWJDZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRc0ZBREFWTVJNd0VRWURWUVFERXdwcmRXSmwKY201bGRHVnpNQjRYRFRJd01EWXdOREE1TVRrME1sb1hEVE13TURZd01qQTVNVGswTWxvd0ZURVRNQkVHQTFVRQpBeE1LYTNWaVpYSnVaWFJsY3pDQ0FTSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnRVBBRENDQVFvQ2dnRUJBSmhiCmFZOVJsR25QVThMclBSd003VnNidUtMV2hsTFBjS3l5Z1Q0bk9iUEhCUlFIWVVhWUJudE1sYnNtUGJmZjVZTzYKUTlCVkJPNmNqZFRpemZRVzRQcnpjdVk4Vm10NnBRbjJXQnpuLzR4WXV3SkRVVEp4YXRGZjgxejUveUpoRkxycApCSkNBYlV2eVpxTmg1Z2U0cW5meU1CZ0dPcmlZdGJSUzRmZmFnMDAwNlRNVmxCY3VnWnZFSWp5SHZyN3hJZjhVCkxvUTNscVBIVFJCQ0ZLWk40cFBhMnhBaW5TdFZFMmhGNGJvVnB1MmZiaDNNY0Q3NHFmNHJsUXhqN3hHQXhzVFoKVWFGYTdYL2dDMzJ5Y2RlOStrRGVKQUF1Q2tzVHhSVXhLOG5ZT3BRejlYMGtnekJOSkYwcVZjVE01TlVtckRFOQpuL3F0WTJhRHhsN2NDUkwyTFk4Q0F3RUFBYU1qTUNFd0RnWURWUjBQQVFIL0JBUURBZ0trTUE4R0ExVWRFd0VCCi93UUZNQU1CQWY4d0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFCNGVkQWNMSDYxYXBPaFZrNkRLWmJwbWpXWVMKQzh2dFBxK1BEcTJBTUhrOXhkV1ZLOUp6UFpZbGgwMjNmSVdIVlZ0NmVLbVFGT0FYS1ZqNnBHa0x3MDVUaWw2TgpJYXlzN2I3Y09DWHVzbzdOa2ZQMjdMYzhCb25zY092ejFZZElET2l4dSswdjlrYU1YSFhCS2gzNmZOSTZyQzc3CmdUN09HQ0luaEFDdFJvZGoxZDZMa1RuTDNuakFtblFNUFBGbW1JZkNEYUxydTkzTEZoYy9PdFViM3M4dGRSczUKS0FQaURoVkY5WVZ6Q3ZYeG9xd2ZlNDZocll2azd6VHVHcFFNdzBIWU1qVUNqN1NrM0pZVFNCN200TmJRUXBkSgo2M0I3SDJ3ZDRNMk1BWDlaNVdjUG9XWHZiLzFVOG5qVHV3RW1jWnVjaGFzTk5SbHJkTzJLMldmY3AyND0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=', clientCertificateData: 'LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM5RENDQWR5Z0F3SUJBZ0lJQzFkSyttV2piMWN3RFFZSktvWklodmNOQVFFTEJRQXdGVEVUTUJFR0ExVUUKQXhNS2EzVmlaWEp1WlhSbGN6QWVGdzB5TURBMk1EUXdPVEU1TkRKYUZ3MHlNVEEzTURrd01URTJOVEJhTURZeApGekFWQmdOVkJBb1REbk41YzNSbGJUcHRZWE4wWlhKek1Sc3dHUVlEVlFRREV4SmtiMk5yWlhJdFptOXlMV1JsCmMydDBiM0F3Z2dFaU1BMEdDU3FHU0liM0RRRUJBUVVBQTRJQkR3QXdnZ0VLQW9JQkFRREJPQS9GZU5RU3lVazgKY0o3a3lUbXBtSXhVbUZaMno2NGdvT0wyQlN6MnlKQXNCd3ZTU1lRbWMybFUrL3d1NnNnYU9reG9BZm44UHF0OQo5MXMwYkNjTlBnT2ZUclFOdjU2U2Zya0YxUk5RUXVJTzUxdHc1blRsVThhUFFyZVFRREZhM0kydHg0dTBVMit6Ck1WZHpLMjRhb25SbndZYWxONmJYQktwaUtPV3IzNVBrajdnT05FME15VS9RVlFaeFIwWTA4K29ZUHhwL3dnNWgKNjcwYnp4d2NjWWNKVENIQWFGd3h1MGZ5aFE1djNXTUxNZWFoWDhmVjRNV0pKZW1BM3M3WXUwMWh1U2ZWM1c4dgpYQkN6QjlRbnpoalZGam1uaUMrb0grSlFUTFFpNXpJanJJYjVFcUxyZEZqc3ppWlYrRC9ISkovaFdmU3RsYVk0ClQ1by9Nb2MzQWdNQkFBR2pKekFsTUE0R0ExVWREd0VCL3dRRUF3SUZvREFUQmdOVkhTVUVEREFLQmdnckJnRUYKQlFjREFqQU5CZ2txaGtpRzl3MEJBUXNGQUFPQ0FRRUFTbVN4bE5zQXhRUTVFR1JJWnFqaGVEZ29NT01EN1B1YQprNlA1VEEraGcwS29FdFI4azF3TTZEcXVTZU5FazZwVm5YYU9TeGNWNTZSOWo1WEw4cXZZN1JHdno0Q0twdTBSCjBOUjhqM2ppcmx2aFN5YkVxbGNzU1ZWbW1aUmVOVXdkdEJ0MG5WR0NwSXQvQnN3RFRuaFN5UW95NFN5MW4rNW0KUGk2NTB4OFlMbE9WOVBDL043RThxNVZTOXJ1K0lkRTlVT1ZmZzhjY3g5K3dLa0Y0ejVhNEVXTGE2Si9DUjQ1eAptZkVLcWxzdFNxcktLM3U0bGZLRmxwWGF1TDd5L3VVcXhYQlk1dnc2U21uaktyL0VMaGFoRzgzU2tOQ3JyM3c4ClVSZ04ySlFYYUdjN1dvcFJOWWk0TkJmYUxtTFNkTHY3OExOUE9vYXgyK2FIMTBlTDhKbjh6QT09Ci0tLS0tRU5EIENFUlRJRklDQVRFLS0tLS0K', clientKeyData: 'LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQpNSUlFcEFJQkFBS0NBUUVBd1RnUHhYalVFc2xKUEhDZTVNazVxWmlNVkpoV2RzK3VJS0RpOWdVczlzaVFMQWNMCjBrbUVKbk5wVlB2OEx1cklHanBNYUFINS9ENnJmZmRiTkd3bkRUNERuMDYwRGIrZWtuNjVCZFVUVUVMaUR1ZGIKY09aMDVWUEdqMEsza0VBeFd0eU5yY2VMdEZOdnN6RlhjeXR1R3FKMFo4R0dwVGVtMXdTcVlpamxxOStUNUkrNApEalJORE1sUDBGVUdjVWRHTlBQcUdEOGFmOElPWWV1OUc4OGNISEdIQ1V3aHdHaGNNYnRIOG9VT2I5MWpDekhtCm9WL0gxZURGaVNYcGdON08yTHROWWJrbjFkMXZMMXdRc3dmVUo4NFkxUlk1cDRndnFCL2lVRXkwSXVjeUk2eUcKK1JLaTYzUlk3TTRtVmZnL3h5U2Y0Vm4wclpXbU9FK2FQektITndJREFRQUJBb0lCQVFDc3RzWXlTSDJaaFYvMwpyTnY3dW52V3c4dTgycWQvY01rLzFWRExoWGpaNkJJbnFPekNQb0RvTmdZVHQyT0hOTXRGMXBMeDdjSmQzazlCClBGakVsV0NiRDdJQk4wTHZmemZwejJqb2M3emQ0OHRhY3loajFUenN1V1FtTHdjUzVLNjVmNmtOaSsrdmMxM0gKbWZXSHQyeW1WazBqYWZSSHYyVmRrb2dUVW1kcXA5Ull0eENKWFRtMndONDZoZ3JaY2Q4Z1ZyQjBSR3NqeGNkUQpXOXBmenFJaUU1L0UvcWJxU2ZNamVzMkNpUkRBZHgyaXNrRWt1K2RqdU82c3ZEejlFQmhtbFhqWHlRckxjcWhYCnpEQ2V6TzJtbjRYTTc0alhicEtWVlBPVjRJYnpQR2UvSDZqWmhnN2ZUVXZmbzdNN0hvZ3loYjZMWTNqMVB0TDQKaVgrV2JWdVJBb0dCQU42aVYrUDBycmltdWl6cTMwUi9Ld2Z4WkZKVitSbk1CR2FEYmNvdit4K2xaSC9id0VQQgowVU5hTlhGSktrZ1dKNG9XdVNScmZpb0sxVXZOZ01yeWtqcS8xNkw1Qm96eFo0MHgxUGF4SkhPV2xiUnVjSTNGCnVWRittUm55V2oxMGN6U3pRdEo5azloa1B5M3c3bjNCVVJLU1lDbW16MjFJa3RVK1BYdE5CcHBOQW9HQkFONHQKS3BDTUdCQnZhc0NUUk5mYjMzYXJrem1paHNBYTB1T1AycWlPRkdRREdaSUkxa1VzYU4vUkRqaFpvclVKN0t3ZQp3N1pzdnVqbGlMVWw3M3orVGdYZXZsQmJQMXUrbm9HMXMzYWpHT3l0cDUwM2lzVmhmZHVWbU9OQmlJUGN1ODBsCkFmMG9ldGtEVURaMGpCRUNqdUgzOUo5bjlCaXhLWjdXd25UT2xDR1RBb0dBZWFLODNrQ3F6UnZhai92cTYrT0cKd1JvenM0QmhUcVRXcXFPWDhtVndrSU91ZXVTM0VNM3Q1UngrSWx6VkN2bC90TVJoZHZKN3hjQ1JkSTdjbFFVZQp1NVpnM0J1dVpvYm1DcEIxU0NyVVBZckNWQWdhMm5weW00SE5hQTJ2Ry9CcG1SdHZvTTBYWDV5MW9BWUlaeENkCm1NWDhZQVZSUXVYcHd6UDBKMCtZRWVrQ2dZQnVkTG9DbndPZnVDUzBsUUxXNWtNVXRudzlYU1hzLytqMHBhSXAKeG1rd3g3SEF2by80Vi9uVHZCVjd3bVIzNlBVM0pSeGI1M2lLUlFOUVBBbnlkR1BKMjFGMmxjYk1EOXF4MWVuaApBM2p5d2VyZzZLb2ZNemJsSWx5ZUx3aDF0aG5RQmFRVmZqaUZCM2FyZkFuZXN3emlIdW9KRGg5MjN5MDRBTUV3ClhUdWI3UUtCZ1FEVEJ6RU1HZmV1ZUg5OEpKUzJGVCt4UjF3MksxNHJxYjExc2FFcy8xL2pTTkx6MUFHZ3Vxa1MKZUpwVkVFRWFxNGg2VElXeWxJVlhIb09YdnVvU2F5SEVyOGZaajZQODVkR2lnRHRQZHc0aW1DYXJSQ2hIaHJ3TAptTVdiUmVSWm1mdE9Vd1U4NERFRTVGeEV1UDNGQ2VtZ3N0bGd0N01XMzVuUmlmWWZIL09DZVE9PQotLS0tLUVORCBSU0EgUFJJVkFURSBLRVktLS0tLQo=', serverUrl: 'https://']
             withCredentials([kubeconfigContent(credentialsId: '754a1850-8415-4acb-b775-3ae8f52de89e', variable: 'KUBECONFIG_CONTENT')]) {
                 sh '''echo "$KUBECONFIG_CONTENT" > kubeconfig && cat kubeconfig && rm kubeconfig'''
             }

        }

    }
}