node {
    stage("Call external service") {
        def get = new URL("http://localhost:8080/api/version").openConnection();
        def rc = get.getResponseCode();
        println ("API call response code: ${rc}");
    }
}