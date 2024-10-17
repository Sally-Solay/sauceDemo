package utils;




import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils extends Logger {

    public static final String fileSeparator = File.separator;

    private static void emptyFile(final String filePath) throws IOException {
        Files.write(Paths.get(filePath), "".getBytes());
    }

    public static void appendFile(final List<String> listOfStrings, final String filePath, final boolean emptyFileFirst) throws IOException {
        if (emptyFileFirst) {
            emptyFile(filePath);
        }
        for (String string : listOfStrings) {
            string = string + "\n";
            byte[] stringToBytes = string.getBytes();
            Files.write(Paths.get(filePath), stringToBytes, StandardOpenOption.APPEND);
        }
    }

    public static void copyFile(final String srcPath, final String destPath) throws IOException {
        org.apache.commons.io.FileUtils.copyFile(Paths.get(srcPath).toFile(), new File(destPath));
    }


    final String REPORTS_FOLDER = "target/logs/";
    private int checkDownloadFolderAttemptsAllowed = 10;






//    public static void setScenarioDirs(final Scenario scenario) {
//        broswer.downloadsFolder = "target/downloads/" + scenario.getName();
//        Configuration.reportsFolder = "target/logs/driver/" + scenario.getName();
//    }

    public void setCheckDownloadFolderAttemptsAllowed(final int attemptsAllowed) {
        if (checkDownloadFolderAttemptsAllowed != attemptsAllowed) {
            checkDownloadFolderAttemptsAllowed = attemptsAllowed;
        }
    }

    public void restoreDefaultValueOfCheckDownloadFolderAttemptsAllowed() {
        setCheckDownloadFolderAttemptsAllowed(10);
    }

    private File getDownloadedFile() throws FileNotFoundException {
        File baseDownloadFolder = new File("D:\\FFregression\\downloads");
        String[] dirs = baseDownloadFolder.list();
        Assert.assertNotNull(dirs);
        File downloadFolderForThisTest = new File(baseDownloadFolder + "\\" + dirs[0]);
        String[] filesInDir = downloadFolderForThisTest.list();
        Assert.assertNotNull(filesInDir);
        int iterationCount = 1;
        while (filesInDir.length < 1 && iterationCount <= checkDownloadFolderAttemptsAllowed) {
            filesInDir = downloadFolderForThisTest.list();
            iterationCount++;
            if (filesInDir.length < 1 && iterationCount > checkDownloadFolderAttemptsAllowed) {
                restoreDefaultValueOfCheckDownloadFolderAttemptsAllowed();
                throw new FileNotFoundException();
            }
        }
        restoreDefaultValueOfCheckDownloadFolderAttemptsAllowed();
        return new File(downloadFolderForThisTest + "\\" + filesInDir[0]);
    }

}
