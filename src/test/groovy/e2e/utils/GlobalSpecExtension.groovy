package e2e.utils

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class GlobalSpecExtension implements IGlobalExtension {

    @Override
    void start() {

    }

    @Override
    void visitSpec(SpecInfo specInfo) {
        specInfo.addListener(new TakeScreenshotOnTestFailureListener())
    }

    @Override
    void stop() {

    }
}

