package configFactory;

public interface ProjectConfig {
    String getProperty(String propertyName, CONFIG fileType);
}
