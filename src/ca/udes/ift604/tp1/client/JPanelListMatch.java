package ca.udes.ift604.tp1.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelListMatch extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private List<Match> listMatch;
    private JButton jButtonUpdate;
    private String nameMatch;
    private boolean selectMatch;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelListMatch(List<Match> listMatch)
    {
        this.listMatch = listMatch;
        nameMatch = listMatch.get(0).getName();
        geometry();
        control();
        appareance();
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    private void geometry()
    {
        jButtonUpdate = new JButton("Actualiser");

        Box boxV = Box.createVerticalBox();

        boxV.add(Box.createVerticalGlue());
        for (final Match element : listMatch)
        {
            JButton jButton = new JButton(element.getName());
            jButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    nameMatch = element.getName();
                    selectMatch = true;
                }
            });
            jButton.setBackground(ColorPalette.BUTTON_BACKGROUND_COLOR);
            jButton.setForeground(ColorPalette.BUTTON_FOREGROUND_COLOR);
            boxV.add(jButton);
            boxV.add(Box.createVerticalGlue());
        }
        Box boxH = Box.createHorizontalBox();
        boxH.add(Box.createHorizontalGlue());
        boxH.add(boxV);
        boxH.add(Box.createHorizontalGlue());
        setLayout(new BorderLayout());

        add(boxH, BorderLayout.CENTER);
        add(jButtonUpdate, BorderLayout.SOUTH);

    }

    private void control()
    {

    }

    private void appareance()
    {
        jButtonUpdate.setBackground(ColorPalette.BUTTON_BACKGROUND_COLOR);
        jButtonUpdate.setForeground(ColorPalette.BUTTON_FOREGROUND_COLOR);
        
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public JButton getjButtonUpdate()
    {
        return this.jButtonUpdate;
    }
    
    public String getNameMatch()
    {
        return this.nameMatch;
    }
    
    public boolean isSelectMatch()
    {
        return this.selectMatch;
    }
    
    /*------------------------------*\
    |*              Set             *|
    \*------------------------------*/
    
    public void setSelectMatch(boolean selectMatch)
    {
        this.selectMatch = selectMatch;
    }

}
