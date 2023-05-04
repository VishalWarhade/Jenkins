node {
    stage ('pull') {
        echo 'pull success'
    }
    stage ('build') {
        echo 'build success'
    }
    stage ('test') {
        echo 'test success'
    }
    stage ('deploy') {
        echo 'deploy success'
    }
}