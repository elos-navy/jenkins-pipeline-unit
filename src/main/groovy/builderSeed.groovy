node {
    stage("Run builder seed") {
        jobDsl targets: ['buildFolders.groovy'] // TODO inject name parameter, ie. simple for loop
    }
}