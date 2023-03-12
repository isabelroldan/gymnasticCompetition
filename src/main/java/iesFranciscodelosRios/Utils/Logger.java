package iesFranciscodelosRios.Utils;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Logger {
    public static void CreateFile(java.util.logging.Logger logger, String filename){
        FileHandler fileHandler=null;
        try{
            fileHandler = new FileHandler(filename + ".txt");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        }catch (SecurityException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);
    }
}
