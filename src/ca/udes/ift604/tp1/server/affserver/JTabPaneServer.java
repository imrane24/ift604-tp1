package ca.udes.ift604.tp1.server.affserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import ca.udes.ift604.tp1.match.Goal;
import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.server.ServerTCP;
import ca.udes.ift604.tp1.server.ServerUDP;
import ca.udes.ift604.tp1.server.affserver.affevent.JPanelEventMatch;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JTabPaneServer extends JTabbedPane
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JPanelCreateMatch jPanelCreateMatch;
    private JPanelEventMatch jPanelEventMatch;
    private JPanelGestBet jPanelGestBet;

    private ServerUDP serverUDP;
    private ServerTCP serverTCP;

    private List<Match> listMatch;
    private int indexMatch = 0;
    private Goal goal;
    private int numMatch;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JTabPaneServer(int portServerUDP, int portServerTCP) throws IOException
    {
        numMatch = 0;
        listMatch = new ArrayList<Match>();
        goal = new Goal(8000, "Jean", "Fred", "Claude");

        // Lance le server UDP pour les matches
        serverUDP = new ServerUDP(portServerUDP, 10);
        serverUDP.setListMatch(listMatch);
        // Lance le server TCP pour les paris
        serverTCP = new ServerTCP(portServerTCP);
        serverTCP.start();

        geometry();
        control();
        appareance();

        new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                serverUDP.start();
            }
        }).start();

        runThreadUpdate();
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    private void geometry()
    {
        jPanelCreateMatch = new JPanelCreateMatch();
        jPanelEventMatch = new JPanelEventMatch(listMatch);
        jPanelGestBet = new JPanelGestBet();

        removeAll();
        add("Creer un match", jPanelCreateMatch);
        add("Event Match", jPanelEventMatch);
        add("Gestion des Paris", jPanelGestBet);
    }

    private void control()
    {

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonStart().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).start();
                serverUDP.setListMatch(listMatch);
            }
        });

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonPause().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).pause();
                serverUDP.setListMatch(listMatch);
            }
        });

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonGoal1().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).team1Goal(goal);
                serverUDP.setListMatch(listMatch);
            }
        });

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonGoal2().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).team2Goal(goal);
                serverUDP.setListMatch(listMatch);
            }
        });

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonPenalty1().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).team1Penalty();
                serverUDP.setListMatch(listMatch);
            }
        });

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonPenalty2().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).team2Penalty();
                serverUDP.setListMatch(listMatch);
            }
        });

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonEndPenalty1().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).team1EndPenalty();
                serverUDP.setListMatch(listMatch);
            }
        });

        // Mise à jour du match en fonction des évenements
        jPanelEventMatch.getjButtonEndPenalty2().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                listMatch.get(indexMatch).team2EndPenalty();
                serverUDP.setListMatch(listMatch);
            }
        });

        // Bouton pour creer un match
        jPanelCreateMatch.getjButtonValidate().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                listMatch.add(new Match(jPanelCreateMatch.getDate(), jPanelCreateMatch.getTeam1(), jPanelCreateMatch.getTeam2(), jPanelCreateMatch
                        .getNameMatch(), numMatch));
                if (numMatch < 10)
                {
                    numMatch++;
                } else
                {
                    numMatch = 0;
                }
                update();
                controlJcombobox();
            }
        });

    }

    private void appareance()
    {
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

    private void controlJcombobox()
    {
        // Selection des matchs à modifier
        jPanelEventMatch.getJcombobox().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                indexMatch = jPanelEventMatch.getIndexMatch();
                update();
            }
        });
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/

    private void runThreadUpdate()
    {
        // Mise à jour du serveur toutes les 30 secondes
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        Thread.sleep(30000);
                        serverUDP.setListMatch(listMatch);
                        // Si on est pas en train de créer un match
                        if (getSelectedIndex() > 0)
                        {
                            update();
                            controlJcombobox();
                        }
                    } catch (InterruptedException e)
                    {
                        // Arret du thread
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }

        }).start();
    }

    private void update()
    {
        int i = getSelectedIndex();
        geometry();
        control();
        appareance();
        setSelectedIndex(i);
        jPanelEventMatch.getJcombobox().setSelectedIndex(indexMatch);
    }
}
