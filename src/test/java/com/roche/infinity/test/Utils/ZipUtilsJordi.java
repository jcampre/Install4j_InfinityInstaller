package com.roche.infinity.test.Utils;

    //Import all needed packages

import java.io.File;
import java.util.List;

import com.roche.infinity.installer.install4j.utils.ZipUtils;

public class ZipUtilsJordi {
        
    private List <String> fileList;
    private static final String outputZipFile = "Folder.zip";
    private static final String sourceFolder = "C:\\Temp"; // SourceFolder path

    public static void main(String[] args) {
        ZipUtils appZip = new ZipUtils();
        appZip.generateFileList(new File(sourceFolder));
        appZip.zipIt(appZip.getOutputZipFile());
    }
}