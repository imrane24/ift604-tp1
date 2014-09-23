package ca.udes.ift604.tp1.tools;

import java.io.IOException;

import ca.udes.ift604.tp1.server.JFrameServer;

public class UseJFrameServer
{

    public static void main(String[] args) throws IOException
    {
        // Port et adresse IP du server
        new JFrameServer(8888);
    }
}
