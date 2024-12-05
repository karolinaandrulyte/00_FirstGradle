package org.example.utils;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;
//loads db-config.yml and parses into a Map<String, Object>.
public class YamlConfigLoader {

    private static final String CONFIG_FILE = "db-config.yml";

    public static Map<String, Object> loadConfig() throws Exception {
        try (InputStream input = YamlConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new Exception("Unable to find " + CONFIG_FILE);
            }

            Yaml yaml = new Yaml();
            return yaml.load(input);
        }
    }
}
