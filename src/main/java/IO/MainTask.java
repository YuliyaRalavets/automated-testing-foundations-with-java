package IO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainTask {
    public static void main(String[] args) {
        if (args.length == 0 || args.length > 1 || args[0].length() == 0)
            System.out.println("Incorrect input args.");
        else {
            String inputFileName = args[0];
            Path input = Paths.get(inputFileName);
            if (input.toFile().exists()) {
                if (input.toFile().isDirectory()) {
                    Charset charset = Charset.forName("UTF-8");
                    try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("fileformain.txt"), charset))) {
                        printTree(input, "", writer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (input.toFile().isFile() && input.endsWith(".txt")) {
                        infoAboutFile(input);
                    } else System.out.println("Incorrect input args. You need to specify the path to the txt file.");
                }
            } else System.out.println("Input path is not exist.");
        }
    }

    private static void printTree(Path path, String space, PrintWriter writer) throws IOException {
        writer.println(path.getFileName());
        if (path.toFile().isDirectory()) {
            List<Path> paths = Files.list(path)
                    .sorted(Comparator.comparing((Path p) -> p.toFile().isDirectory()).thenComparing(Path::getFileName))
                    .collect(Collectors.toList());
            List<Path> dirs = paths
                    .stream()
                    .filter(p -> p.toFile().isDirectory())
                    .collect(Collectors.toList());
            for (int i = 0; i < paths.size(); i++) {
                if (paths.get(i).toFile().isFile()) {
                    writer.printf("%s%s ", space, dirs.size() == 0 ? " " : "\u2502  ");
                    printTree(paths.get(i), space, writer);
                } else {
                    writer.printf("%s%s\u2500\u2500\u2500", space, i == paths.size() - 1 ? "\u2514" : "\u251c");
                    printTree(paths.get(i), String.format("%s%s", space, i == paths.size() - 1 ? "   " : "\u2502  "), writer);
                }
            }
        }
    }

    private static void infoAboutFile(Path path){
        long filesCount = 0;
        long dirsCount = 0;
        double length = 0;
        Path parent = path.getParent();
        int d = path.getNameCount();
        textInfo(parent,filesCount,dirsCount,length,d);
    }

    private static void textInfo (Path path, long files, long dirs, double len, int count){
        long filesCount = files;
        long dirsCount = dirs;
        Path root = path.getRoot();
        if (root.equals(path)) {
            filesCount += countOfFilesInPath(path);
            dirsCount += countOfDirInPath(path);
            len += lengthOfFileName(path);
            System.out.println("Total Dirs "  + dirsCount);
            System.out.println("Total Files " + filesCount);
            System.out.printf("Average length is %.2f", (double)len/filesCount);
            System.out.printf("\nAverage number of files per folder is %.2f", (double)filesCount/count );
        }else {
            filesCount += countOfFilesInPath(path);
            dirsCount += countOfDirInPath(path);
            len += lengthOfFileName(path);
            textInfo(path.getParent(),filesCount,dirsCount,len,count);
        }
    }

    private static long countOfDirInPath(Path path) {
        List<File> files = Arrays
                .stream((path.toFile().listFiles()))
                .collect(Collectors.toList());
        return files
                .stream()
                .filter(File::isDirectory)
                .count();
    }

    private static long countOfFilesInPath(Path path) {
        List<File> files = Arrays
                .stream((path.toFile().listFiles()))
                .collect(Collectors.toList());
        return files
                .stream()
                .filter(File::isFile)
                .count();
    }

    private static double lengthOfFileName(Path path){
        int length = 0;
        List<File> files = Arrays
                .stream((path.toFile().listFiles()))
                .collect(Collectors.toList())
                .stream().filter(File::isFile)
                .collect(Collectors.toList());
        for(File f: files){
            length += f.getName().length();
        }
        return length;
    }
}



