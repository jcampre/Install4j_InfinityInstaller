package com.roche.infinity.installer.install4j.utils;

    //Import all needed packages

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.install4j.api.Util;

public class ZipUtils {

    private List <String> fileList;
    private String outputZipFile = "C:\\tmp\\Folder.zip";
    private String sourceFolder = "C:\\Temp"; // SourceFolder path

    public String getOutputZipFile() {
		return outputZipFile;
	}

	public void setOutputZipFile(String destinationZipFile) {
		outputZipFile = destinationZipFile;
	}
	
	public String getSourceFolder() {
		return sourceFolder;
	}

	public void setSourceFolder(String sourceFolderOrFile) {
		sourceFolder = sourceFolderOrFile;
	}
	
    public ZipUtils() {
        fileList = new ArrayList < String > ();
    }


    public ZipUtils(String sourceFolder, String outputFile) {
        this.sourceFolder = sourceFolder;
        this.outputZipFile = outputFile;
        
        ZipUtils appZip = new ZipUtils();
        appZip.generateFileList(new File(sourceFolder));
        appZip.zipIt(getOutputZipFile());
    }

    public void zipIt(String zipFile) {
    	
    	Util.logInfo(null, "fitxer extern : " + zipFile); 
        byte[] buffer = new byte[1024];
        String source = new File(sourceFolder).getName();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);

            System.out.println("Output to Zip : " + zipFile);
            FileInputStream in = null;

            for (String file: this.fileList) {
                System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(source + File.separator + file);
                zos.putNextEntry(ze);
                try {
                    in = new FileInputStream(sourceFolder + File.separator + file);
                    int len;
                    while ((len = in .read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                } finally {
                    in.close();
                }
            }

            zos.closeEntry();
            System.out.println("Folder successfully compressed");
            Util.showMessage("Folder successfully compressed");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generateFileList(File node) {
        // add file only
        if (node.isFile()) {
        	Util.logInfo(null, node.toString());
            fileList.add(generateZipEntry(node.toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename: subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    private String generateZipEntry(String file) {
        return file.substring(sourceFolder.length() + 1, file.length());
    }
}