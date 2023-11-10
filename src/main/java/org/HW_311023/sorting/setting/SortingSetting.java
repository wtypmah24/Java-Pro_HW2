package org.HW_311023.sorting.setting;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Sorting method (-a or -d) is not compulsory parameter. By default increased method is used.
 * dataType (-s or -i) is compulsory parameter.
 * outputFileName (any output file name) is compulsory parameter.
 * inputFiles List of the input file names, at least one input file  must be provided.
 */
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SortingSetting {
    private boolean increaseMethod = true;
    private String dataType;
    private String outputFileName;
    private final List<String> inputFiles;
}
