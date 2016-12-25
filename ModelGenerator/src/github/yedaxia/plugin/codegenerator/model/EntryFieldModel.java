package github.yedaxia.plugin.codegenerator.model;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class EntryFieldModel {

    private String remoteFieldName;
    private String caseFieldName;
    private String fieldName;
    private String fieldType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getRemoteFieldName() {
        return remoteFieldName;
    }

    public void setRemoteFieldName(String remoteFieldName) {
        this.remoteFieldName = remoteFieldName;
    }

    public String getCaseFieldName() {
        return caseFieldName;
    }

    public void setCaseFieldName(String caseFieldName) {
        this.caseFieldName = caseFieldName;
    }
}
