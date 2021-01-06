package tech.tongyu.external.generate;

import java.util.List;

public interface IFormatGenerator {
    String transformAndSaveFile(String fileName, Header header, List<BodyElement> bodyElementList);
}

