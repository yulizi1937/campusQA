package gui;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Scruel on 2016/12/21.
 * GitHub: http://www.GitHub.com/scruel
 */
public class QARobotStart {
  private Socket client = null;
  private ObjectOutputStream writer;
  private ObjectInputStream reader;

  public QARobotStart() throws Exception {
    String host = "127.0.0.1";
    int port = 8899;
    client = new Socket(host, port);

    reader = new ObjectInputStream(client.getInputStream());
    writer = new ObjectOutputStream(client.getOutputStream());
    writer.writeObject("login");
    writer.flush();
    writer.writeObject("robot");
    writer.flush();
    writer.writeObject("00000000");
    writer.flush();
  }
}
