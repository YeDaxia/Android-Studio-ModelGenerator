package github.yedaxia.plugin.codegenerator;

import com.intellij.openapi.project.Project;
import github.yedaxia.plugin.codegenerator.builder.EntryClassBuilder;
import github.yedaxia.plugin.codegenerator.builder.EntryFieldBuilder;
import github.yedaxia.plugin.codegenerator.builder.EntryGetterBuilder;
import github.yedaxia.plugin.codegenerator.builder.EntrySetterBuilder;
import github.yedaxia.plugin.codegenerator.model.EntryFieldModel;
import github.yedaxia.plugin.codegenerator.provider.DefaultEntryProvider;
import github.yedaxia.plugin.codegenerator.provider.IEntryProvider;
import github.yedaxia.plugin.codegenerator.provider.ProviderFactory;

import java.util.List;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class EntryCodeGenerator {

    private static final String FILE_FIELD_TEMPLATE = "Entry_Field_template";
    private static final String FILE_GETTER_TEMPLATE = "Entry_Getter_template";
    private static final String FILE_SETTER_TEMPLATE = "Entry_Setter_template";
    private static final String FILE_CLASS_TEMPLATE = "Entry_template";

    public static String generateCode(Project project,String className, String objectText){
        IEntryProvider entryProvider = ProviderFactory.createProvider();
        List<EntryFieldModel> entryFields = entryProvider.provideEntryFields(objectText);

        StringBuilder fieldStrings = new StringBuilder();
        StringBuilder methodStrings = new StringBuilder();

        ResourceTemplateProvider resourceTemplateProvider = new ResourceTemplateProvider();
        String fieldTemplate = resourceTemplateProvider.provideTemplateForName(FILE_FIELD_TEMPLATE);
        String getterTemplate = resourceTemplateProvider.provideTemplateForName(FILE_GETTER_TEMPLATE);
        String setterTemplate = resourceTemplateProvider.provideTemplateForName(FILE_SETTER_TEMPLATE);
        String classTemplate = resourceTemplateProvider.provideTemplateForName(FILE_CLASS_TEMPLATE);

        for (EntryFieldModel entryFieldModel : entryFields){
            EntryFieldBuilder fieldBuilder = new EntryFieldBuilder(fieldTemplate,entryFieldModel);
            fieldStrings.append(fieldBuilder.builtString());
            EntryGetterBuilder getterBuilder = new EntryGetterBuilder(getterTemplate,entryFieldModel);
            methodStrings.append(getterBuilder.builtString());
            EntrySetterBuilder setterBuilder = new EntrySetterBuilder(setterTemplate,entryFieldModel);
            methodStrings.append(setterBuilder.builtString());
        }

        if(methodStrings.charAt(methodStrings.length() -1 )== '\n'){
            methodStrings.deleteCharAt(methodStrings.length() -1);
        }

        EntryClassBuilder classBuilder = new EntryClassBuilder(classTemplate, className,fieldStrings.toString(),methodStrings.toString());
        return classBuilder.builtString();
    }
}
