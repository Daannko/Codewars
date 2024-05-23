import java.io.FileNotFoundException;

public class MyThread extends Thread{
    String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Files file = new Files(this.name);
            file.countRows();
            System.out.println(file.getNewLineCounter());
            file = null;
            System.gc();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
