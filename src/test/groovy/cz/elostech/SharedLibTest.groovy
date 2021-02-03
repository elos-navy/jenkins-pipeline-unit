package cz.elostech

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.ProjectSource.projectSource
import com.lesfurets.jenkins.unit.BasePipelineTest

class SharedLibTest extends BasePipelineTest {
    
    @Override
    @Before
    void setUp() throws Exception {

        def library = library().name('buildTools')
                        .defaultVersion("<notNeeded>")
                        .allowOverride(true)
                        .implicit(true)
                        .targetPath('<notNeeded>')
                        .retriever(projectSource("src/main/groovy"))
                        .build()
        helper.registerSharedLibrary(library)

        scriptRoots += 'src/main/groovy'
        super.setUp()
    }

    @Test
    void test_local_sharedlib() throws Exception {
        
        runScript("src/main/groovy/testLib.groovy")
        
        // script.execute()
        printCallStack()
        assertJobStatusSuccess()
    }
}