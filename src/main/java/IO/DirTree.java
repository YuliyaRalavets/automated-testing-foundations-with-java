package IO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class DirTree {
    //private HashSet<Path> pathSet = new HashSet<>();
    private Path dirPath;
    private String fileExt;

    public DirTree(Path dirPath) {
        this.dirPath = dirPath;
    }

    private void walkDirectory (Path path, String shift) {
        // Сначала делаю обход по директориям. Создаю для этого фильтр DirectoryStream.Filter<Path>
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, p->Files.isDirectory(p))) {
            for (Path entry : directoryStream) {
                //System.out.println("dir");
                System.out.println( shift + "|-----" + entry.toFile().getName());
                walkDirectory(entry, shift + "  ");
                //continue;
                /*for (Path pathFromSet: pathSet) { // проверяю есть ли файлы с расширением fileExt в подпапках
                        walkDirectory(entry,shift + "     ");
                        break;
                    }
                }*/
            }


               /*
                if (pathSet.contains(entry)) { // усли в текущей папке есть файлы с расширением fileExt, то
                    System.out.println(shift + entry.toFile().getName());
                    walkDirectory(entry,shift + "     ");
                    continue;
                }*/
                /*for (Path pathFromSet : pathSet) { // проверяю есть ли файлы с расширением fileExt в подпапках
                    if (pathFromSet.startsWith(entry)) {
                        System.out.println(shift + entry.toFile().getName());
                        walkDirectory(entry, shift + "     ");
                        break;
                    }
                }*/

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, p-> Files.isRegularFile(p))) {
            for (Path entry : directoryStream) {
                System.out.println(shift + entry.toFile().getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showTree() {
        try {
            Files.walk(dirPath);
            /*Files.walkFileTree(dirPath, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

                    //pathSet.add(dir); // запоминаю все папки, так как нужно будет вывести все содержимое каталогов
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    //pathSet.add(file.getParent());
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                    //System.out.println("|--" + dir.toFile().getName());
                    return FileVisitResult.CONTINUE;
                }
            });*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dirPath.toFile().getName());
        walkDirectory(dirPath, "");
    }

}
