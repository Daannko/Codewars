import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {

    private String name;
    private  File file;
    private int rowCounter ;

    public Files(String name) throws FileNotFoundException {
        this.name = name;
        file = new File(name);
    }

    public void countRows() throws FileNotFoundException {
        if(this.file.exists())
        {
            this.rowCounter=0;
            Scanner myReader = new Scanner(this.file);
            while(myReader.nextLine()!=null&&myReader.hasNextLine())
            {
               this.rowCounter+=1;
            }
            myReader.close();
            this.rowCounter++;
        }
    }

    public String getName() {
        return name;
    }

    public File getFileVar() {
        return file;
    }

    public int getNewLineCounter() {
        return rowCounter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileVar(File fileVar) {
        file = fileVar;
    }

    public void setNewLineCounter(int newLineCounter) {
        rowCounter = newLineCounter;
    }


}
