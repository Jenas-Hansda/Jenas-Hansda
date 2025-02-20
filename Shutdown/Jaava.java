import java.io.IOException;
public class ShutdownPC {
    public static void main(String[] args) {
        try {
            //Shutdown the PC Using Java
            Runtime.getRuntime().exec("Shutdown /s /t 1");
        } catch (IOException e) {
            e.printStackTrace();
        
        }
    }
}