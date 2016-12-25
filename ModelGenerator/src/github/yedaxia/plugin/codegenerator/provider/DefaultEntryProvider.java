package github.yedaxia.plugin.codegenerator.provider;

import github.yedaxia.plugin.codegenerator.model.EntryFieldModel;
import github.yedaxia.plugin.utils.EntryFieldHelper;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class DefaultEntryProvider implements IEntryProvider{

    @Override
    public List<EntryFieldModel> provideEntryFields(String tableText) {
        BufferedReader reader = new BufferedReader(new StringReader(tableText));
        String lineText;
        List<EntryFieldModel> fieldsList = new ArrayList<EntryFieldModel>();
        try {
            while ((lineText = reader.readLine()) != null) {
                lineText = lineText.trim();
                if (StringUtils.isEmpty(lineText)) {
                    continue;
                }
                String[] cellTexts = lineText.split("\\s");
                if (cellTexts.length >= 2) {
                    EntryFieldModel entryFieldModel = new EntryFieldModel();
                    String remoteFieldName = cellTexts[0].trim();
                    entryFieldModel.setRemoteFieldName(remoteFieldName);
                    String fieldName = EntryFieldHelper.getPrefFieldName(remoteFieldName);
                    entryFieldModel.setFieldName(fieldName);
                    entryFieldModel.setCaseFieldName(StringUtils.capitalize(fieldName));
                    String fieldType = EntryFieldHelper.getPrefFieldType(cellTexts[1].trim());
                    entryFieldModel.setFieldType(fieldType);
                    fieldsList.add(entryFieldModel);
                }
            }
            return fieldsList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
