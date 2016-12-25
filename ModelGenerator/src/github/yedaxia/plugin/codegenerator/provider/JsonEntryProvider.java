package github.yedaxia.plugin.codegenerator.provider;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import github.yedaxia.plugin.codegenerator.model.EntryFieldModel;
import github.yedaxia.plugin.utils.EntryFieldHelper;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class JsonEntryProvider implements IEntryProvider{

    @Override
    public List<EntryFieldModel> provideEntryFields(String objectJson) {
        JsonParser jsonParser = new  JsonParser();
        JsonObject jsonObject = jsonParser.parse(objectJson).getAsJsonObject();
        if(jsonObject == null){
            return null;
        }
        List<EntryFieldModel> fieldsList = new ArrayList<EntryFieldModel>();
        EntryFieldModel fieldModel;
        for(Map.Entry<String,JsonElement> fieldEntry : jsonObject.entrySet()){
            fieldModel = new EntryFieldModel();
            String remoteFieldName = fieldEntry.getKey();
            fieldModel.setRemoteFieldName(remoteFieldName);
            String fieldName = EntryFieldHelper.getPrefFieldName(remoteFieldName);
            fieldModel.setFieldName(fieldName);
            fieldModel.setFieldType(getFieldType(fieldEntry.getValue()));
            fieldModel.setCaseFieldName(StringUtils.capitalize(fieldName));
            fieldsList.add(fieldModel);
        }
        return fieldsList;
    }

    private String getFieldType(JsonElement fieldElement){
        return "String";
    }
}
