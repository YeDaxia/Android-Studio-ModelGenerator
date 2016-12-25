package github.yedaxia.plugin.codegenerator.provider;

import github.yedaxia.plugin.codegenerator.model.EntryFieldModel;

import java.util.List;

/**
 * Created by user on 2016/12/25.
 */
public interface IEntryProvider {

    /**
     *
     * @param entryDictText
     * @return
     */
    List<EntryFieldModel> provideEntryFields(String entryDictText);
}