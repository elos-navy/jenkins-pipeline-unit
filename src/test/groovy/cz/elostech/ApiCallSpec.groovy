package cz.elostech
import org.junit.Rule
//import com.github.tomakehurst.wiremock.client.WireMock
//import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.github.tomakehurst.wiremock.*
import com.github.tomjankes.wiremock.WireMockGroovy
import spock.lang.Specification
import spock.lang.Shared
import org.jvnet.hudson.test.JenkinsRule
import org.junit.ClassRule
import spock.lang.Unroll

class ApiCallSpec extends Specification {
    
    @Shared
    @ClassRule
    private JenkinsRule jenkinsRule = new JenkinsRule()

    @Rule
    WireMockRule wireMockRule = new WireMockRule()


    def wireMockStub = new WireMockGroovy()

    def "test feature using external REST resource" () {
        given:
        wireMockStub.stub {
            request {
                method "GET"
                url "http://localhost:8080/api/version"
            }
            response {
                status 200
                body "Some body"
                headers {
                    "Content-Type" "text/plain"
                }
            }
        }

        when:
        // TODO execute jenkins harness and job
        println("TODO")

        then:
        1 == wireMockStub.count {
            method "GET"
            url "http://localhost:8080/api/version"
        }
    }
}