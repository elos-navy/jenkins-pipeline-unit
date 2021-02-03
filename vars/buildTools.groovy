// Parse Git repo URL, return hashmap

@NonCPS
def parseGitURL(String url) {
    def urlMatcher = url =~ '^(https?://[^/]*/bitbucket)/scm/([^/]*)/([^/]*).git$'
    def result
    if (urlMatcher) {
        def gitServer = urlMatcher[0][1]
        def projectKey = urlMatcher[0][2]
        def repoSlug = urlMatcher[0][3]

        result = ['gitServer' : gitServer, 'projectKey' : projectKey, 'repoSlug' : repoSlug]
    } else 
        result = [:]

    return result
}