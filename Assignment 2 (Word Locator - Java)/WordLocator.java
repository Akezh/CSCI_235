package wordlocator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections; // Used for sorting the List
import java.util.TreeSet;
import java.util.Queue;
import java.util.LinkedList;

public class WordLocator implements WordLocatorInterface {
    private TreeSet<String> words;
    private TreeSet<String> filePaths;
    private File document;

    public WordLocator(String fileName) {
        words = new TreeSet<String>();
        filePaths = new TreeSet<String>();
        document = new File(fileName);
    }

    static boolean isInWord(char ch) {
        // Apostrophe and hyphen cases
        if (ch == 0x2019 || ch == 0x27 || ch == '-')
            return true;
        // Digit cases
        if ('0' <= ch && ch <= '9')
            return true;
        // Alphabetic cases
        ch = Character.toLowerCase(ch);
        return ('a' <= ch && ch <= 'z');
    }

    public TreeSet<String> getWords() {
        try {
            Queue<File> contents = new LinkedList<>(); // Linked List Queue
            // TODO: Check whether the document is a file or directory
            for (File file : document.listFiles()) {
                contents.add(file);
            }

            while (!contents.isEmpty()) {
                File curFile = contents.poll(); // curFile = currentFile
                if (curFile.isDirectory()) {
                    File[] newDirContents = curFile.listFiles();
                    for (File newFile : newDirContents) {
                        contents.add(newFile);
                    }
                } else {
                    int ch;
                    String token = "";
                    BufferedReader reader = new BufferedReader(new FileReader(curFile));
                    do {
                        ch = reader.read();
                        if (!isInWord((char)ch)) {
                            if (token.length() > 0) {
                                words.add(token.toLowerCase());
                                token = "";
                            }
                        } else {
                            token = token + (char)ch;
                        }
                    } while (ch != -1);
                }
            }
        } catch (Exception ex) {
            System.out.println("No file or directory found");
        }

        return words;
    }

    public TreeSet<String> getFilepaths() {
        try {
            Queue<File> contents = new LinkedList<>(); // Linked List Queue
            for (File file : document.listFiles()) {
                contents.add(file);
            }
            while (!contents.isEmpty()) {
                File curFile = contents.poll();
                if (curFile.isDirectory()) {
                    for (File newFile : curFile.listFiles()) {
                        contents.add(newFile);
                    }
                } else {
                    filePaths.add(curFile.getPath());
                }
            }

        } catch (Exception ex) {
            System.out.println("No file or directory found");
        }

        return filePaths;
    }

    public int numOccurancesInAllFiles(String word) {
        int countOccurances = 0;
        try {
            Queue<File> contents = new LinkedList<>(); // Linked List Queue
            for (File file : document.listFiles()) {
                contents.add(file);
            }
            while (!contents.isEmpty()) {
                File curFile = contents.poll();
                if (curFile.isDirectory()) {
                    for (File newFile : curFile.listFiles()) {
                        contents.add(newFile);
                    }
                } else {
                    int ch;
                    String token = "";
                    BufferedReader reader = new BufferedReader(new FileReader(curFile));
                    do {
                        ch = reader.read();
                        if (!isInWord((char)ch)) {
                            if (token.length() > 0) {
                                if (token.toLowerCase().equals(word.toLowerCase()))
                                    countOccurances++;
                                token = "";
                            }
                        } else {
                            token = token + (char)ch;
                        }
                    } while (ch != -1);
                }
            }

        } catch (Exception ex) {
            System.out.println("No file or directory found");
        }

        return countOccurances;
    }

    public void printOccurancesInAllFiles(String word) {
        try {
            Queue<File> contents = new LinkedList<>(); // Linked List Queue
            for (File file : document.listFiles()) {
                contents.add(file);
            }

            List<File> files = new ArrayList<>();
            while (!contents.isEmpty()) {
                File curFile = contents.poll();
                if (curFile.isDirectory()) {
                    for (File newFile : curFile.listFiles()) {
                        contents.add(newFile);
                    }
                } else {
                    files.add(curFile);
                }
            }

            Collections.sort(files); // Sorting the files alphabetically

            for (File curFile : files) {
                int ch;
                int col = 1;
                int line = 1;
                String token = "";
                BufferedReader reader = new BufferedReader(new FileReader(curFile));
                do {
                    ch = reader.read();
                    col++;
                    if (!isInWord((char)ch)) {
                        if (token.length() > 0) {
                            if (token.toLowerCase().equals(word.toLowerCase())) {
                                int tempCol = col - token.length() - 1;
                                Location location = new Location(curFile.getPath(), line, tempCol);
                                System.out.println(location);
                            }
                            token = "";
                        }

                        if (ch == '\n') {
                            line++;
                            col = 1;
                        }
                    } else {
                        token = token + (char)ch;
                    }
                } while (ch != -1);
            }
        } catch (Exception ex) {
            System.out.println("No file or directory found");
        }
    }

    public int numOccurancesInFile(String filepath, String word) {
        int countOccurances = 0;
        try {
            File givenFile = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(givenFile));
            int ch;
            String token = "";
            do {
                ch = reader.read();
                if (!isInWord((char)ch)) {
                    if (token.length() > 0) {
                        if (token.toLowerCase().equals(word.toLowerCase()))
                            countOccurances++;
                        token = "";
                    }
                } else {
                    token = token + (char)ch;
                }
            } while (ch != -1);

        } catch (Exception ex) {
            System.out.println("The file not found");
        }

        return countOccurances;
    }

    public void printOccurancesInFile(String filepath, String word) {
        try {
            File givenFile = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(givenFile));
            int ch;
            int col = 1;
            int line = 1;
            String token = "";
            do {
                ch = reader.read();
                col++;
                if (!isInWord((char) ch)) {

                    if (token.length() > 0) {
                        if (token.toLowerCase().equals(word.toLowerCase())) {
                            int tempCol = col - token.length() - 1;
                            Location location = new Location(givenFile.getPath(), line, tempCol);
                            System.out.println(location);
                        }
                        token = "";
                    }

                    if (ch == '\n') {
                        line++;
                        col = 1;
                    }
                } else {
                    token = token + (char)ch;
                }
            } while (ch != -1);
        } catch (Exception ex) {
            System.out.println("No file or directory found");
        }
    }
}
