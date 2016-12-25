package github.yedaxia.plugin.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by user on 2016/12/25.
 */
public class EntryFieldHelper {

    public static String getPrefFieldName(String originFieldName){
        String[] names = originFieldName.split("_");
        if(names.length == 1){
            return StringUtils.uncapitalize(names[0]);
        }
        StringBuilder fieldNameBuilder = new StringBuilder();
        fieldNameBuilder.append(StringUtils.uncapitalize(names[0]));
        for (int i = 1; i < names.length; i++) {
            fieldNameBuilder.append(StringUtils.capitalize(names[i]));
        }
        return fieldNameBuilder.toString();
    }

    public static String getPrefFieldType(String fieldType) {
        if(fieldType.equalsIgnoreCase("int") || fieldType.equalsIgnoreCase("integer")){
            return "int";
        }else if(fieldType.equalsIgnoreCase("short")){
            return "short";
        }else if(fieldType.equalsIgnoreCase("byte")){
            return "byte";
        }else if(fieldType.equalsIgnoreCase("long")){
            return "long";
        }else if(fieldType.equalsIgnoreCase("boolean") || fieldType.equalsIgnoreCase("bool")){
            return "boolean";
        }else if(fieldType.equalsIgnoreCase("float")){
            return "float";
        }else if(fieldType.equalsIgnoreCase("double")){
            return "double";
        }else{
            return "String";
        }
    }
}
