package ca.udes.ift604.tp1.tools;

import java.io.IOException;

import ca.udes.ift604.tp1.client.JFrameClient;

public class UseJFrameClient
{

    public static void main(String[] args) throws IOException
    {
        // Port et adresse IP du server
        new JFrameClient(8000, 8002, "192.168.56.1");
    }
}
