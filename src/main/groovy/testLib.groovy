node {
    stage('Use SharedLib function') {
        def result = buildTools.parseGitURL("https://git.example.com/bitbucket/scm/project-test/test-repo.git")
        echo result.gitServer
        echo result.projectKey
        echo result.repoSlug
    }
}
