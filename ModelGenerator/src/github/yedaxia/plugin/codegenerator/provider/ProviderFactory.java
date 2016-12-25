package github.yedaxia.plugin.codegenerator.provider;

/**
 * Created by user on 2016/12/25.
 */
public class ProviderFactory {

    public static IEntryProvider createProvider(){
        return new JsonEntryProvider();
    }
}
