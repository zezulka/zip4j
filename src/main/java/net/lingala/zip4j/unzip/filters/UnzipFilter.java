package net.lingala.zip4j.unzip.filters;

import java.util.function.Predicate;
import net.lingala.zip4j.model.FileHeader;

/**
 * Marker interface.

 */
public interface UnzipFilter extends Predicate<FileHeader> {
}
