package configFactory;

import java.util.function.Supplier;

public enum ProjectConfigType {
    INITCONFIG(InitConfig::new),
    TESTDATAPATH(TestDataPath::new);

    private final Supplier<ProjectConfig> constructor;

    ProjectConfigType(Supplier<ProjectConfig> constructor) {
        this.constructor = constructor;
    }

    public Supplier<ProjectConfig> getConstructor() {
        return this.constructor;
    }
}
