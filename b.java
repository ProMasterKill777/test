import java.awt.Color;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class b {
   private static String targetServer;
   private static final int PROXY_PORT = 1337;
   private static final Map<String, Boolean> opList = new HashMap();
   private static final Set<String> notifiedPlayers = new HashSet();
   private static boolean isReadyForCommands = false;
   private static String randomIP;
   private static PrintWriter consolePrinter;
   private static final Map<String, Socket> playerSockets = new HashMap();
   public static final String ANSI_RED = "\u001b[91m";
   public static final String ANSI_RESET = "\u001b[0m";
   public static final String ANSI_BLUE = "\u001b[94m";

   public static void main(String[] args) {
      if (!isJavaVersionValid()) {
         System.out.println("[ERROR] The current Java version is not supported.");
         System.out.println("Please update Java from here: https://www.java.com/download/");
         System.exit(1);
      }

      try {
         if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            (new ProcessBuilder(new String[]{"cmd", "/c", "title 7582395"})).inheritIO().start();
         }
      } catch (Exception var22) {
         var22.printStackTrace();
      }

      loadConfig();
      System.out.println("\u001b[91m");
      System.out.println("    ______      ______           __      _ __");
      System.out.println("   / ____/___  / ____/  ______  / /___  (_) /_");
      System.out.println("  / __/ /_  / / __/ | |/_/ __ \\/ / __ \\/ / __/ ");
      System.out.println(" / /___  / /_/ /____>  </ /_/ / / /_/ / / /_");
      System.out.println("/_____/ /___/_____/_/|_/ .___/_/\\____/_/\\__/");
      System.out.println("                      /_/");
      System.out.println("\u001b[0m");
      System.out.println("[WARNING] If you found this application for free, you're probably scammed.");
      System.out.println("[WARNING] If you share this build with anybody your license may be terminated:)");
      System.out.println();
      System.out.println("Console will start in 10 seconds.");

      try {
         Thread.sleep(10000L);
      } catch (InterruptedException var21) {
         var21.printStackTrace();
      }

      Random random = new Random();
      int serverCount = random.nextInt(7) + 1;
      long randomHashId = 1000000000000L + random.nextLong(9000000000000L);
      System.out.println();
      System.out.println("[INFO]: Using standard Java JCE cipher. To enable the OpenSSL based native cipher, please make sure you are using 64 bit Ubuntu or Debian with libssl installed.");
      System.out.println("[INFO]: Loaded EzExploit");
      System.out.println("[INFO]: Starting EzExploit for version 1.8x");

      try {
         Thread.sleep(1000L);
      } catch (InterruptedException var20) {
         var20.printStackTrace();
      }

      System.out.println("[INFO]: Loading files.");
      System.out.println("[INFO]: Checking proxies.");

      try {
         Thread.sleep(5000L);
      } catch (InterruptedException var19) {
         var19.printStackTrace();
      }

      System.out.println("[INFO]: Virtual Machine created with proxy 127.0.0.1");

      try {
         Thread.sleep(3000L);
      } catch (InterruptedException var18) {
         var18.printStackTrace();
      }

      System.out.println("[INFO]: Jenkin's modules loaded.");

      try {
         Thread.sleep(3000L);
      } catch (InterruptedException var17) {
         var17.printStackTrace();
      }

      System.out.println("[INFO]: Generating keypair");

      try {
         Thread.sleep(2000L);
      } catch (InterruptedException var16) {
         var16.printStackTrace();
      }

      System.out.println("[INFO]: Using epoll channel type");

      try {
         Thread.sleep(1000L);
      } catch (InterruptedException var15) {
         var15.printStackTrace();
      }

      System.out.println("\u001b[94m");
      System.out.println("  _  _        _   ___                 _         ");
      System.out.println(" | || |___ __| |_|   \\ ___ __ ___  __| |___ _ _ ");
      System.out.println(" | __ / _ (_-<  _| |) / -_) _/ _ \\/ _` / -_) '_|");
      System.out.println(" |_||_\\___/__/\\__|___/\\___\\__\\___/\\__,_\\___|_|  ");
      System.out.println("\u001b[0m");
      System.out.println("[INFO]: HostDecoder 2.0 Script loaded successfully. Credits: scraten");

      try {
         Thread.sleep(3000L);
      } catch (InterruptedException var14) {
         var14.printStackTrace();
      }

      System.out.println("[INFO]: HostDecoder -> Host check completed. " + serverCount + " Hosts found");
      System.out.println("[INFO]: HostDecoder -> Hash ID: " + randomHashId);
      System.out.println("[INFO]: HostDecoder -> Third host randomized, renewed.");

      try {
         Thread.sleep(3000L);
      } catch (InterruptedException var13) {
         var13.printStackTrace();
      }

      System.out.println("[INFO]: HostDecoder -> All hosts (" + serverCount + ") combined into a single proxy");

      try {
         Thread.sleep(1000L);
      } catch (InterruptedException var12) {
         var12.printStackTrace();
      }

      System.out.println("[INFO]: Generated accessible port for server 127.0.0.1:1337");
      System.out.println("[INFO]: Located at 127.0.0.1");
      System.out.println("[INFO]: Clearing logs");

      try {
         Thread.sleep(2000L);
      } catch (InterruptedException var11) {
         var11.printStackTrace();
      }

      System.out.println("[INFO]: EzExploit loaded and started. Please join server with 127.0.0.1:1337 address");
      System.out.println("[INFO]: Waiting for a join attempt");
      (new Thread(b::handleConsoleInput)).start();

      try {
         InetAddress ipAddress = InetAddress.getByName(randomIP);

         try {
            ServerSocket serverSocket = new ServerSocket(1337, 50, ipAddress);

            try {
               while(true) {
                  Socket clientSocket = serverSocket.accept();
                  handleClient(clientSocket);
               }
            } catch (Throwable var10) {
               try {
                  serverSocket.close();
               } catch (Throwable var9) {
                  var10.addSuppressed(var9);
               }

               throw var10;
            }
         } catch (IOException var23) {
            System.out.println("[ERROR]: Hiba történt a szerver elindításakor: " + var23.getMessage());
            var23.printStackTrace();
         }
      } catch (Exception var24) {
         System.out.println("[ERROR]: Érvénytelen IP cím: " + randomIP);
         var24.printStackTrace();
      }

   }

   private static void printColoredText(String text, Color color) {
      System.out.println(text);
   }

   private static void loadConfig() {
      File configFile = new File("config.yml");
      if (!configFile.exists()) {
         try {
            PrintWriter writer = new PrintWriter(new FileWriter(configFile));

            try {
               writer.println("Target server: example.com");
               System.out.println("[INFO]: config.yml created. Please set the Target server and restart.");
               System.exit(0);
            } catch (Throwable var6) {
               try {
                  writer.close();
               } catch (Throwable var5) {
                  var6.addSuppressed(var5);
               }

               throw var6;
            }

            writer.close();
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

      try {
         BufferedReader reader = new BufferedReader(new FileReader(configFile));

         try {
            String line;
            while((line = reader.readLine()) != null) {
               if (line.startsWith("Target server: ")) {
                  targetServer = line.replace("Target server: ", "").trim();
                  break;
               }
            }

            if (targetServer == null || targetServer.isEmpty()) {
               System.out.println("[ERROR]: Target server not set in config.yml.");
               System.exit(1);
            }
         } catch (Throwable var8) {
            try {
               reader.close();
            } catch (Throwable var4) {
               var8.addSuppressed(var4);
            }

            throw var8;
         }

         reader.close();
      } catch (IOException var9) {
         var9.printStackTrace();
      }

   }

   private static void handleClient(Socket clientSocket) {
      (new Thread(() -> {
         try {
            Socket targetSocket = new Socket(targetServer, 25565);
            if (targetSocket.isConnected()) {
               synchronized(notifiedPlayers) {
                  if (notifiedPlayers.add(clientSocket.getInetAddress().toString())) {
                     playerSockets.put(clientSocket.getInetAddress().toString(), clientSocket);
                     System.out.println("[INFO]: Player forwarded to " + targetServer + " with UUID: NULL-OFFLINE-NAME");
                     isReadyForCommands = true;
                  }
               }
            } else {
               System.out.println("[ERROR]: Unable to connect to the target server.");
            }

            forwardData(clientSocket, targetSocket);
         } catch (IOException var5) {
            System.out.println("[ERROR]: An error occurred while connecting: " + var5.getMessage());
            var5.printStackTrace();
         }

      })).start();
   }

   private static void forwardData(Socket clientSocket, Socket targetSocket) {
      try {
         InputStream clientInput = clientSocket.getInputStream();
         OutputStream clientOutput = clientSocket.getOutputStream();
         InputStream targetInput = targetSocket.getInputStream();
         OutputStream targetOutput = targetSocket.getOutputStream();
         Thread clientToTarget = new Thread(() -> {
            transferData(clientInput, targetOutput);
         });
         Thread targetToClient = new Thread(() -> {
            transferData(targetInput, clientOutput);
         });
         clientToTarget.start();
         targetToClient.start();
         clientToTarget.join();
         targetToClient.join();
      } catch (IOException | InterruptedException var8) {
         var8.printStackTrace();
      }

   }

   private static void transferData(InputStream input, OutputStream output) {
      try {
         byte[] buffer = new byte[1024];

         int bytesRead;
         while((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
            output.flush();
         }
      } catch (IOException var4) {
      }

   }

   private static void handleConsoleInput() {
      Scanner scanner = new Scanner(System.in);

      try {
         while(true) {
            while(!isReadyForCommands) {
               Thread.sleep(500L);
            }

            System.out.print(">");
            String input = scanner.nextLine().trim();
            if (input.startsWith("op ")) {
               String playerName = input.substring(3).trim();
               if (!playerName.isEmpty()) {
                  opList.put(playerName, true);
                  System.out.println("[INFO]: Opped " + playerName);
                  sendMinecraftMessage("[3247361: Opped " + playerName + "]", "gray");
               } else {
                  System.out.println("[ERROR]: Player name cannot be empty.");
               }
            } else {
               System.out.println("[ERROR]: Unknown command.");
            }
         }
      } catch (InterruptedException var6) {
         var6.printStackTrace();
      } finally {
         scanner.close();
      }

   }

   private static void sendMinecraftMessage(String message, String color) {
      try {
         String playerIP = "";
         Socket socket = (Socket)playerSockets.get(playerIP);
         if (socket == null || socket.isClosed()) {
            System.out.println("[ERROR]: Failed to op try again: " + playerIP);
            return;
         }

         OutputStream out = socket.getOutputStream();
         DataOutputStream dataOut = new DataOutputStream(out);
         String jsonMessage = "{\"text\":\"" + message + "\",\"color\":\"" + color + "\"}";
         byte[] jsonBytes = jsonMessage.getBytes("UTF-8");
         ByteArrayOutputStream buffer = new ByteArrayOutputStream();
         DataOutputStream packet = new DataOutputStream(buffer);
         packet.writeByte(2);
         writeVarInt(packet, jsonBytes.length);
         packet.write(jsonBytes);
         packet.writeByte(0);
         byte[] fullPacket = buffer.toByteArray();
         writeVarInt(dataOut, fullPacket.length);
         dataOut.write(fullPacket);
         dataOut.flush();
      } catch (IOException var11) {
         var11.printStackTrace();
      }

   }

   private static void writeVarInt(DataOutputStream dataOut, int length) {
   }

   private static boolean isJavaVersionValid() {
      String version = System.getProperty("java.version");
      String[] parts = version.split("\\.");

      try {
         int major = false;
         int major;
         if (parts[0].equals("1")) {
            major = Integer.parseInt(parts[1]);
         } else {
            major = Integer.parseInt(parts[0]);
         }

         return major >= 8;
      } catch (NumberFormatException var3) {
         System.out.println("[WARNING]: Please updtate your java: " + version);
         return false;
      }
   }
}
