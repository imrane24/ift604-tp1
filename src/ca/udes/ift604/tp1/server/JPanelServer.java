package ca.udes.ift604.tp1.server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.match.Team;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelServer extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JButton jButtonStart;
    private JButton jButtonPause;
    private JButton jButtonGoal1;
    private JButton jButtonGoal2;
    private JButton jButtonPenalty1;
    private JButton jButtonPenalty2;
    private JButton jButtonEndPenalty1;
    private JButton jButtonEndPenalty2;

    private ServerUDP server;
    private int indexMatch = 0;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelServer(int portServer)
    {

        List<Match> maList = new ArrayList<Match>();
        maList.add(new Match(new Date(), new Team("Bale"), new Team("Young Boys"), "match1"));
        maList.add(new Match(new Date(), new Team("Xamax"), new Team("Schaffouse"), "match2"));
        maList.add(new Match(new Date(), new Team("Sion"), new Team("SRD"), "match3"));

        try
        {
            server = new ServerUDP(portServer, 10);
            server.setListMatch(maList);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        geometry();
        control();
        appareance();

        new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                server.start();
            }
        }).start();

    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    private void geometry()
    {
        jButtonGoal1 = new JButton("But Equipe 1");
        jButtonGoal2 = new JButton("But Equipe 2");
        jButtonPenalty1 = new JButton("Penalitée 1");
        jButtonPenalty2 = new JButton("Penalitée 2");
        jButtonEndPenalty1 = new JButton("Fin Penalitée 1");
        jButtonEndPenalty2 = new JButton("Fin Penalitée 2");
        jButtonStart = new JButton("Start");
        jButtonPause = new JButton("Pause");

        setLayout(new GridLayout(4, 2, 10, 10));

        add(jButtonStart);
        add(jButtonPause);
        add(jButtonGoal1);
        add(jButtonGoal2);
        add(jButtonPenalty1);
        add(jButtonPenalty2);
        add(jButtonEndPenalty1);
        add(jButtonEndPenalty2);
    }

    private void control()
    {
        jButtonStart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).start();
            }
        });

        jButtonPause.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).pause();
            }
        });

        jButtonGoal1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).team1Goal();
            }
        });

        jButtonGoal2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).team2Goal();
            }
        });

        jButtonPenalty1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).team1Penalty();
            }
        });

        jButtonPenalty2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).team2Penalty();
            }
        });

        jButtonEndPenalty1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).team1EndPenalty();
            }
        });

        jButtonEndPenalty2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                server.getListMatch().get(indexMatch).team2EndPenalty();
            }
        });

    }

    private void appareance()
    {
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/
}
