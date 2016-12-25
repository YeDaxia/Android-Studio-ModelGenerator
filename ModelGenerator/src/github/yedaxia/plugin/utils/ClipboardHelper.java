package github.yedaxia.plugin.utils;

import com.intellij.openapi.ide.CopyPasteManager;

import java.awt.datatransfer.StringSelection;
import java.io.Serializable;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ClipboardHelper {

    public static void copy(String generatedCode) {
        CopyPasteManager.getInstance().setContents(new StringSelection(generatedCode));
    }
}
