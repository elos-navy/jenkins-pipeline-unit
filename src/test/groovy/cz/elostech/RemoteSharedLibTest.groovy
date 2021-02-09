package cz.elostech

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.GitSource.gitSource
import com.lesfurets.jenkins.unit.BasePipelineTest

class RemoteSharedLibTest extends BasePipelineTest {
    
    @Override
    @Before
    void setUp() throws Exception {
        scriptRoots += 'src/main/groovy'
        scriptRoots += 'vars'
        def library = library()
                        .name('buildTools')
                        .retriever(gitSource('https://github.com/elos-tech/jenkins-pipeline-unit.git'))
                        .targetPath("target/tmp")
                        .defaultVersion("shared-lib")
                        .allowOverride(false)
                        .implicit(true)
                        .build()
        helper.registerSharedLibrary(library)

        super.setUp()
    }

    @Test
    void test_remote_sharedlib() throws Exception {
        
        runScript("src/main/groovy/testLib.groovy")
        
        // script.execute()
        printCallStack()
        assertJobStatusSuccess()
    }
}