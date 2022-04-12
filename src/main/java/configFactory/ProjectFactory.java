package configFactory;

public class ProjectFactory {

    public static ProjectConfig getConfig(ProjectConfigType type) {
        return type.getConstructor().get();
    }
}
