import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    private static void copyFileUsingJava7Files(File source,File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException{
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try{
            inputStream = new FileInputStream(source);
            outputStream= new FileOutputStream(dest);

            int length;
            byte[]buffer = new byte[1024];

            while ((length = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
            outputStream.close();
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source file : ");
        String sourcePath =scanner.nextLine();
        System.out.println("Enter dest file : ");
        String destPath = scanner.nextLine();

        File source = new File(sourcePath);
        File dest = new File(destPath);

        try {
           copyFileUsingStream(source,dest);
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("Can't copy that file !");
            System.out.println(e.getMessage());
        }
    }

}
