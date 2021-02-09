package cz.elostech
import org.junit.Rule
//import com.github.tomakehurst.wiremock.client.WireMock
//import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.github.tomakehurst.wiremock.*
import com.github.tomjankes.wiremock.WireMockGroovy


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
    then:
    1 == wireMockStub.count {
        method "GET"
        url "http://localhost:8080/api/version"
    }
}