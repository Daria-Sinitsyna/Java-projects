import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.*;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        FileOutputStream fos = new FileOutputStream("output1.txt");

        fos.write('[');
        for(int i = 0; i < array.length; i++){
            fos.write(48 + array[i]);

            if(i < array.length - 1) {
                fos.write(',');
            }
        }
        fos.write(']');
        fos.flush();
        fos.close();

        String dirName = ".";

        try{
            copyFilesToBackup(dirName, "./backup");
        }catch (IOException e){
            e.printStackTrace();
        }

        // --------------------------------------------
        /**
         * Предположить, что числа в исходном массиве из 9 элементов имеют диапазон [0,
         * 3], и представляют собой, например, состояния ячеек поля для игры в крестикинолики,
         * где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3
         * – резервное значение. Такое предположение позволит хранить в одном числе типа
         * int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта
         */

        byte[] xZero = {0, 1, 2, 3, 0, 1, 2, 1, 3};
        int len = xZero.length;

        FileOutputStream fos1 = new FileOutputStream("output_xZero.dat");
        DataOutputStream dos = new DataOutputStream(fos1);

        try {
            for(byte element : xZero){
                dos.writeByte(element);
            }
            System.out.println("done!");
        }catch (IOException e){
            e.printStackTrace();
        }

        // --------------------------------------------
        /**
         * Прочитать числа из файла, полученного в результате выполнения задания 2
         */

        try{
            byte[] xZeroAfterReading = readxZero("output_xZero.dat", len);

            for(byte element : xZeroAfterReading){
                System.out.println(element);
            }
        }catch (IOException e){
            e.printStackTrace();
        }




    }

    public static byte[] readxZero(String fileName, int len) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(fis);

        byte[] xZero = new byte[len];
        for(int i = 0; i < len; i++){
            xZero[i] = dis.readByte();
        }
        return xZero;
    }


    /**
     * Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
     * во вновь созданную папку ./backup
     */

    public static void printAllFiles(String path) {
        try(DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Path.of(path))) {
            for(Path entry : dirstrm){
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFilesToBackup(String sourceDir, String backupDir) throws IOException {
        Path sPath = Paths.get(sourceDir);
        Path bPath = Paths.get(backupDir);

        if(!Files.exists(bPath)){
            Files.createDirectories(bPath);
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sPath)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    copyFile(entry, bPath.resolve(entry.getFileName()));
                }
            }
        }
        

}

    private static void copyFile(Path source, Path destination) throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
    }
