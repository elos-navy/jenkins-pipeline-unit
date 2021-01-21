package cz.elostech

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import com.lesfurets.jenkins.unit.BaseRegressionTest

class TestRegression extends BaseRegressionTest {
    @Before
    void setUp() throws Exception {
        scriptRoots += 'src/main/groovy'
        super.setUp()
    }

    @Test
    void testNonReg() throws Exception {
        def script = loadScript("src/main/groovy/testJob.groovy")
        script.execute()
        super.testNonRegression('example')
    }
}