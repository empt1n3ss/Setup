import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final StringBuilder log = new StringBuilder();
    public static void main(String[] args) {
        List<String> directories = Arrays.asList("C:/f/Games", "C:/f/Games/src","C:/f/Games/src/main","C:/f/Games/src/test", "C:/f/Games/res", "C:/f/Games/savegames", "C:/f/Games/temp");

        for (String directoryPath : directories) {
            createDirectory(directoryPath);
        }
        createFiles("C:/f/Games/src/main/Main.java");
        createFiles("C:/f/Games/src/main/Utils.java");

        File tempTxt = new File("C:/f/Games/temp/temp.txt");
        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write((log.toString()));
            System.out.println("Лог успешно записан");
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога" + e.getMessage());
        }
    }
    private static void createDirectory(String directoryPath){
        File directory = new File(directoryPath);
            if (directory.mkdir()) {
                log.append("Папка ").append(directoryPath).append(" успешно создана\n");
            } else {
                log.append("Ошибка при создании папки").append(directoryPath).append("\n");
            }
        }
    private static void createFiles(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                log.append("Файл ").append(file.getName()).append(" создан успешно\n");
            } else {
                log.append("Ошибка при создании файла ").append(filePath).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файлов Main.java и Utils.java: ").append(e.getMessage()).append("\n");
        }
    }
}