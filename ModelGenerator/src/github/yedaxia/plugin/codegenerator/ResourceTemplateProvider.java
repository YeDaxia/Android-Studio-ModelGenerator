package github.yedaxia.plugin.codegenerator;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class ResourceTemplateProvider {

    public String provideTemplateForName(String templateName) {
        URL url = getClass().getClassLoader().getResource(templateName);
        try {
            return Resources.toString(url, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
