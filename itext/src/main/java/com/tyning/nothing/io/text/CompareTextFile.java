package com.tyning.nothing.io.text;

import java.io.File;
import java.io.IOException;
import java.util.List;

import difflib.*;
import org.apache.commons.io.FileUtils;

public class CompareTextFile {

    public  static void compare() throws IOException {
        List<String> original = FileUtils.readLines(new File("src/main/resources/1.txt"),"UTF-8");
        List<String> revised = FileUtils.readLines(new File("src/main/resources/2.txt"),"UTF-8");

        Patch<String> patch = DiffUtils.diff(original, revised);

        for (Delta<String> delta : patch.getDeltas()) {
            List<?> list = delta.getRevised().getLines();
            for (Object object : list) {
                System.out.println(object);
            }
        }

        DiffRowGenerator.Builder builder = new DiffRowGenerator.Builder();
        builder.showInlineDiffs(false);
        DiffRowGenerator generator = builder.build();
        for (Delta delta :  patch.getDeltas()) {
            List<DiffRow> generateDiffRows = generator.generateDiffRows((List<String>) delta.getOriginal().getLines(), (List<String>) delta
                    .getRevised().getLines());
            int leftPos = delta.getOriginal().getPosition();
            int rightPos = delta.getRevised().getPosition();
            for (DiffRow row : generateDiffRows) {
                DiffRow.Tag tag = row.getTag();
                if (tag == DiffRow.Tag.INSERT) {
                    System.out.println("Insert: ");
                    System.out.println("new-> " + row.getNewLine());
                    System.out.println("");
                } else if (tag == DiffRow.Tag.CHANGE) {
                    System.out.println("change: ");
                    System.out.println("old-> " + row.getOldLine());
                    System.out.println("new-> " + row.getNewLine());
                    System.out.println("");
                } else if (tag == DiffRow.Tag.DELETE) {
                    System.out.println("delete: ");
                    System.out.println("old-> " + row.getOldLine());
                    System.out.println("");
                } else if (tag == DiffRow.Tag.EQUAL) {
                    System.out.println("equal: ");
                    System.out.println("old-> " +  row.getOldLine());
                    System.out.println("new-> " +  row.getNewLine());
                    System.out.println("");
                } else {
                    throw new IllegalStateException("Unknown pattern tag: " + tag);
                }
            }
        }
    }

}
