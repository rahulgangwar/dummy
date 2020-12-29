package sapient;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum FileType {
    CSV("csv");

    FileType(String extension) {
        this.extension = extension;
    }

    private final String extension;
    private static Map<String, FileType> map;

    static {
        map = Arrays.stream(values()).collect(Collectors.toMap(FileType::getExtension, v -> v));
    }

    public String getExtension() {
        return extension;
    }

    public static FileType of(String extension) {
        System.out.println("Getting file type for extension:" + extension);
        return Optional.ofNullable(extension)
                .map(x -> map.get(x))
                .orElseThrow(
                        () ->
                                new IllegalArgumentException(
                                        String.format("Invalid data:%s", extension)));
    }
}
