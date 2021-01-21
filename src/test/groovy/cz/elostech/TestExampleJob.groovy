package cz.elostech

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import com.lesfurets.jenkins.unit.BasePipelineTest
// import com.lesfurets.jenkins.unit.MethodCall

class TestExampleJob extends BasePipelineTest {
        @Rule
        public ExpectedException thrown = ExpectedException.none()

        @Override
        @Before
        void setUp() throws Exception {
            scriptRoots += 'src/main/groovy'
            super.setUp()
        }

        @Test
        void should_execute_without_errors() throws Exception {
            def script = loadScript("src/main/groovy/testJob.groovy")
            script.execute()
            printCallStack()
        }
}