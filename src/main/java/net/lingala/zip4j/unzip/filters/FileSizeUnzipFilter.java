package net.lingala.zip4j.unzip.filters;

import net.lingala.zip4j.model.FileHeader;

public class FileSizeUnzipFilter implements UnzipFilter {

    private final long lowerBound;
    private final long upperBound;
    private final boolean isSizeCompressed;

    private FileSizeUnzipFilter(long lowerBound, long upperBound, boolean isSizeCompressed) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.isSizeCompressed = isSizeCompressed;
    }
    
    public static FileSizeUnzipFilter withCompressedUpperBound(long upperBound) {
        return new FileSizeUnzipFilter(0, upperBound, true);
    }
    
    public static FileSizeUnzipFilter withUncompressedUpperBound(long upperBound) {
        return new FileSizeUnzipFilter(0, upperBound, false);
    }
    
    public static FileSizeUnzipFilter withCompressedLowerBound(long lowerBound) {
        return new FileSizeUnzipFilter(lowerBound, 0, true);
    }
    
    public static FileSizeUnzipFilter withUncompressedLowerBound(long lowerBound) {
        return new FileSizeUnzipFilter(lowerBound, 0, false);
    }
    
    public static FileSizeUnzipFilter withCompressedLowerAndUpperBound(long lowerBound, long upperBound) {
        return new FileSizeUnzipFilter(lowerBound, upperBound, true);
    }
    
    public static FileSizeUnzipFilter withUncompressedLowerAndUpperBound(long lowerBound, long upperBound) {
        return new FileSizeUnzipFilter(lowerBound, upperBound, false);
    }
    
    
    @Override
    public boolean test(FileHeader t) {
        long sizeToCompare = isSizeCompressed ? t.getCompressedSize() : t.getUncompressedSize();
        return sizeToCompare <= upperBound && sizeToCompare >= lowerBound;
    }
    
}
