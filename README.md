# Jenkins

## Jenkins installation 

- `yum install wget -y`
- `wget -O /etc/yum.repos.d/jenkins.repo     https://pkg.jenkins.io/redhat-stable/jenkins.repo`
- `rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key`
- `yum install java-11-openjdk -y`
- `yum install jenkins`
- `systemctl daemon-reload`
- `systemctl start jenkins`