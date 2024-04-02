import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        List<String> directories = Arrays.asList("C:/f/Games", "C:/f/Games/src","C:/f/Games/src/main","C:/f/Games/src/test", "C:/f/Games/res", "C:/f/Games/savegames", "C:/f/Games/temp");
        createDirectories(directories, log);
        createFiles(log);

        File tempTxt = new File("C:/f/Games/temp/temp.txt");
        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write((log.toString()));
            System.out.println("Лог успешно записан");
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога" + e.getMessage());
        }
    }
    public static void createDirectories(List<String> directories, StringBuilder log){
        for (String directoryPath : directories) {
            File directory = new File(directoryPath);
            if (directory.mkdir()) {
                log.append("Папка ").append(directoryPath).append(" усешно создана\n");
            } else {
                log.append("Ошибка при создании папки").append(directoryPath).append("\n");
            }
        }
    }
    private static void createFiles(StringBuilder log) {
        try {
            File mainJavaFile = new File("C:/f/Games/src/main/Main.java");
            File utilsJavaFile = new File("C:/f/Games/src/main/Utils.java");
            if (mainJavaFile.createNewFile() && utilsJavaFile.createNewFile()) {
                log.append("Файлы Main.java и Utils.java созданы успешно\n");
            } else {
                log.append("Ошибка при создании файлов Main.java и Utils.java\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файлов Main.java и Utils.java: ").append(e.getMessage()).append("\n");
        }
    }
}