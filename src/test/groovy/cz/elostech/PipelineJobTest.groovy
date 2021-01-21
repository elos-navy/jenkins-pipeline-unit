package cz.elostech

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import com.lesfurets.jenkins.unit.declarative.*


//DeclarativePipelineTest
class PipelineJobTest extends DeclarativePipelineTest {
        
        def script_src = "src/main/groovy/Jenkinsfile.test"

        @Override
        @Before
        void setUp() throws Exception {
            
            scriptRoots += 'src/main/groovy'
            super.setUp()
            //helper.addShMock('java -version', 'example', 0)
            //helper.registerAllowedMethod("sh", [String], {c -> 0})
        }

        @Test
        void should_execute_without_errors() throws Exception {
            helper.addShMock('java -version', 'example', 0)
            runScript("src/main/groovy/Jenkinsfile.test")
            
            // script.execute()
            printCallStack()
            assertJobStatusSuccess()
        }
        
        @Test
        void should_fail_pipeline() throws Exception {
            helper.addShMock('java -version', 'noexample', 0)
            runScript("src/main/groovy/Jenkinsfile.test")
            // script.execute()
            printCallStack()
            assertJobStatusFailure()
        }     
}