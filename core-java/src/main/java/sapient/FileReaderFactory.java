package sapient;

public class FileReaderFactory {
    public static FileReader getFileReader(String filename) {
        System.out.println("Getting file reader for filename : " + filename);
        int lastIndexOf = filename.lastIndexOf(".");
        FileType fileType = FileType.of(filename.substring(lastIndexOf + 1));
        FileReader fileReader = null;
        switch (fileType) {
            case CSV:
                fileReader = new CsvFileReader();
        }
        return fileReader;
    }
}
