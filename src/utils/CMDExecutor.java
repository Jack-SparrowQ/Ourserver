package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMDExecutor {

    public static void runServeo(int port) {
        try {

            //String comando = "cmd.exe /c start cmd.exe /k \"ssh -R "+port+":localhost:"+port+" serveo.net\""; 

            ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c","start","cmd.exe", "/c", "ssh -R  8081:localhost:" + port + " serveo.net");
            builder.redirectErrorStream(true); // Combina salida de error con la salida estándar
            Process proceso = builder.start();

            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
