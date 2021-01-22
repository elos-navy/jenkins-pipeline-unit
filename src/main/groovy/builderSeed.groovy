node {
    stage("Run builder seed") {
        jobDsl targets: ['vars/buildFolders.groovy'] // TODO inject name parameter, ie. simple for loop
    }
}