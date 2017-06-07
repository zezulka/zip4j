package net.lingala.zip4j.unzip.filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.lingala.zip4j.model.FileHeader;

public class ExtensionUnzipFilter implements UnzipFilter {

    private final List<String> satisfactoryExtensions;

    public ExtensionUnzipFilter(String... args) {
        this.satisfactoryExtensions = Arrays.asList(args);
    }
    
    public ExtensionUnzipFilter(List<String> args) {
        this.satisfactoryExtensions = new ArrayList<>(args);
    }

    @Override
    public boolean test(FileHeader t) {
        String fileName = t.getFileName();
        return (satisfactoryExtensions.stream().anyMatch((phrase) -> (fileName.endsWith(phrase))));
    }
}
