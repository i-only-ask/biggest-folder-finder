import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {


    public static void main(String[] args) {
        String folderPath = "F:\\мое\\фильмотека\\сериалы";
        long sizeLimit = 500 * 1024 * 1024;
        File file = new File(folderPath);
        Node root = new Node(file,sizeLimit);

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
    }
}