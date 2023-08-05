package com.TecAlliance.runner;

import com.TecAlliance.steps.GoogleSearchSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import java.util.Collections;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class GoogleSearchTest extends JUnitStories {
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(this.getClass()))
                        .withFormats(Format.CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new GoogleSearchSteps());
    }

    @Override
    public List<String> storyPaths() {
        StoryFinder finder = new StoryFinder();
        return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Collections.singletonList("**/*.story"), List.of(""));
    }
}
