import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        File srcFolder = new File("C:\\f\\Games\\src");
        if (srcFolder.mkdir()) {
            log.append("Папка src создана успешно\n");
        } else {
            log.append("Ошибка при создании папки src\n");
        }

        File mainFolder = new File(srcFolder, "main");
        File testFolder = new File(srcFolder, "test");
        if (mainFolder.mkdir() && testFolder.mkdir()) {
            log.append("Папки main и test созданы успешно\n");
        } else {
            log.append("Ошибка при создании папок main и test\n");
        }

        File mainJavaFile = new File(mainFolder, "Main.java");
        File utilsJavaFile = new File(mainFolder, "Utils.java");
        try {
            if (mainJavaFile.createNewFile() && utilsJavaFile.createNewFile()) {
                log.append("Файлы Main.java и Utils.java созданы успешно\n");
            } else {
                log.append("Ошибка при создании файлов Main.java и Utils.java\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файлов Main.java и Utils.java: ").append(e.getMessage()).append("\n");
        }

        File resFolder = new File("C:\\f\\Games\\res");
        if (resFolder.mkdir()) {
            log.append("Папка res создана успешно\n");
        } else {
            log.append("Ошибка при создании папки res\n");
        }

        File drawablesFolder = new File(resFolder, "drawables");
        File vectorsFolder = new File(resFolder, "vectors");
        File iconsFolder = new File(resFolder, "icons");
        if (drawablesFolder.mkdir() && vectorsFolder.mkdir() && iconsFolder.mkdir()) {
            log.append("Папки drawables, vectors и icons созданы успешно\n");
        } else {
            log.append("Ошибка при создании папок drawables, vectors и icons\n");
        }

        File savegamesFolder = new File("C:\\f\\Games\\savegames");
        if (savegamesFolder.mkdir()) {
            log.append("Папка savegames создана успешно\n");
        } else {
            log.append("Ошибка при создании папки savegames\n");
        }

        File tempFolder = new File("C:\\f\\Games\\temp");
        File tempTxtFile = new File(tempFolder, "temp.txt");
        try {
            if (tempFolder.mkdir() && tempTxtFile.createNewFile()) {
                log.append("Папка temp и файл temp.txt созданы успешно\n");
            } else {
                log.append("Ошибка при создании папки temp и файла temp.txt\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании папки temp и файла temp.txt: ").append(e.getMessage()).append("\n");
        }
        try (FileWriter writer = new FileWriter(tempTxtFile)) {
            writer.write(log.toString());
            System.out.println("Лог успешно записан в файл temp.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога в файл temp.txt: " + e.getMessage());
        }
    }
}