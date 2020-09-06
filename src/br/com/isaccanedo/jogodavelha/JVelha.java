package br.com.isaccanedo.jogodavelha;

/**
 * Programa: Jogo da Velha
 * Desenvolvido por: Isac Canedo de Almeida
 * Data: 05/07/2008
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JVelha extends JFrame  implements WindowListener {

 /*------------------------------------------------------------------------------------------------------*/
            // Declaracao das variaveis 
 /*------------------------------------------------------------------------------------------------------*/
    private static JMenuBar mb;
    private static JMenu arquivo;
    private static JMenu ajuda;
    private static JMenu escolha;
    private static JMenu dificuldade;
    private static JMenuItem sobre;
    private static JMenuItem novo;
    private static JMenuItem sair;
    private static JMenuItem amigo;
    private static JMenuItem computador;
    private static JRadioButtonMenuItem facil;
    private static JRadioButtonMenuItem medio;
    private static JRadioButtonMenuItem dificil;
    private static JButton botao1;
    private static JButton botao2;
    private static JButton botao3;
    private static JButton botao4;
    private static JButton botao5;
    private static JButton botao6;
    private static JButton botao7;
    private static JButton botao8;
    private static JButton botao9;
    private static int cont = 1, c = -1, comp = 0;
    private static int b1 = -1, b2 = -1, b3 = -1, b4 = -1, b5 = -1, b6 = -1, b7 = -1, b8 = -1, b9 = -1;
    private static boolean jogo = false, computf = false, computm = false, computd = false, comput = false;
    private static JPanel painel;
   
    
 /*------------------------------------------------------------------------------------------------------*/
            // Cria um nova instancia da Classe 
 /*------------------------------------------------------------------------------------------------------*/
    public JVelha() {
        
        mb = new JMenuBar();
        arquivo = new JMenu();
        ajuda = new JMenu();
        escolha = new JMenu();
        dificuldade = new JMenu();
        sobre = new JMenuItem();
        novo = new JMenuItem();
        sair = new JMenuItem();
        computador = new JMenuItem();
        amigo = new JMenuItem();
        facil = new JRadioButtonMenuItem();
        medio = new JRadioButtonMenuItem();
        dificil = new JRadioButtonMenuItem();

        mb.setBackground(new Color(249,249,230));
        arquivo.setBackground(new Color(249,249,230));
        arquivo.setText("Arquivo");
        mb.add(arquivo);
        novo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        novo.setBackground(new Color(249,249,230));
        novo.setText("Novo");
        arquivo.add(novo);
        novo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                novo();
            }
        });
        sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        sair.setBackground(new Color(249,249,230));
        sair.setText("Sair");
        arquivo.add(sair);
        sair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                System.exit(0);
            }
        });
        
        
        escolha.setBackground(new Color(249,249,230));
        escolha.setText("Adversario");
        mb.add(escolha);
        
        dificuldade.setBackground(new Color(249,249,230));
        dificuldade.setText("Dificuldade");
        mb.add(dificuldade);
        
	amigo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        amigo.setBackground(new Color(249,249,230));
        amigo.setText("Amigo");
        escolha.add(amigo);
        amigo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                comput = false;
                computd = false;
                computm = false;
                computf = false;
            }
        });

	computador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        computador.setBackground(new Color(249,249,230));
        computador.setText("Computador");
        computador.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                comput = true;
                facil.setSelected(true);
                medio.setSelected(false);
                dificil.setSelected(false);
                computf = true;
                computm = false;
                computd = false;
            }
        });        
        escolha.add(computador);
        
        facil.setBackground(new Color(249, 249, 230));
        facil.setText("Facil");
        facil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                comput = true;
                computf = true;
                computm = false;
                computd = false;
                facil.setSelected(true);
                medio.setSelected(false);
                dificil.setSelected(false);
            }
        });
        dificuldade.add(facil);
        
        medio.setBackground(new Color(249, 249, 230));
        medio.setText("Médio");
        medio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                comput = true;
                computm = true;
                computf = false;
                computd = false;
                facil.setSelected(false);
                medio.setSelected(true);
                dificil.setSelected(false);
            }
        });
        dificuldade.add(medio);
        
        dificil.setBackground(new Color(249, 249, 230));
        dificil.setText("Difícil");
        dificil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                comput = true;
                computm = false;
                computf = false;
                computd = true;
                facil.setSelected(false);
                medio.setSelected(false);
                dificil.setSelected(true);
            }
        });
        dificuldade.add(dificil);
       
        
        ajuda.setBackground(new Color(249,249,230));
        ajuda.setText("Ajuda");
        mb.add(ajuda);
        sobre.setBackground(new Color(249,249,230));
        sobre.setText("Sobre");
        ajuda.add(sobre);
        sobre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                JOptionPane.showMessageDialog(null, "Copyright 2008, Isac Canedo de Almeida", "Jogo da Velha", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        setJMenuBar(mb);
        
        botao1 = new JButton();
        botao1.setBackground(new Color(249,249,230));
        botao1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b1 == -1) 
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9))
                    {
                        botao1.setFont(new Font("Dialog",0,66));
                        botao1.setText("X");
                        b1 = 1;
                    }
                    else
                    {
                        botao1.setFont(new Font("Dialog",0,66));
                        botao1.setText("O");
                        b1 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }    
            }
        });
        botao2 = new JButton();
        botao2.setBackground(new Color(249,249,230));
        botao2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b2 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9))
                    {
                        botao2.setFont(new Font("Dialog",0,66));
                        botao2.setText("X");
                        b2 = 1;
                    }
                    else 
                    {
                        botao2.setFont(new Font("Dialog",0,66));
                        botao2.setText("O");
                        b2 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                } 
            }
        });
        botao3 = new JButton();
        botao3.setBackground(new Color(249,249,230));
        botao3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b3 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9))
                    {
                        botao3.setFont(new Font("Dialog",0,66));
                        botao3.setText("X");
                        b3 = 1;
                    }
                    else 
                    {
                        botao3.setFont(new Font("Dialog",0,66));
                        botao3.setText("O");
                        b3 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }
            }
        });
        botao4 = new JButton();
        botao4.setBackground(new Color(249,249,230));
        botao4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b4 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9))
                    {
                        botao4.setFont(new Font("Dialog",0,66));
                        botao4.setText("X");
                        b4 = 1;
                    }
                    else 
                    {
                        botao4.setFont(new Font("Dialog",0,66));
                        botao4.setText("O");
                        b4 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }
            }
        });
        botao5 = new JButton();
        botao5.setBackground(new Color(249,249,230));
        botao5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b5 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9))
                    {
                        botao5.setFont(new Font("Dialog",0,66));
                        botao5.setText("X");
                        b5 = 1;
                    }
                    else 
                    {
                        botao5.setFont(new Font("Dialog",0,66));
                        botao5.setText("O");
                        b5 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }
            }
        });
        botao6 = new JButton();
        botao6.setBackground(new Color(249,249,230));
        botao6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b6 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9))
                    {
                        botao6.setFont(new Font("Dialog",0,66));
                        botao6.setText("X");
                        b6 = 1;
                    }
                    else 
                    {
                        botao6.setFont(new Font("Dialog",0,66));
                        botao6.setText("O");
                        b6 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }
            }
        });
        botao7 = new JButton();
        botao7.setBackground(new Color(249,249,230));
        botao7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b7 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9)) 
                    {
                        botao7.setFont(new Font("Dialog",0,66));
                        botao7.setText("X");
                        b7 = 1;
                    }
                    else 
                    {
                        botao7.setFont(new Font("Dialog",0,66));
                        botao7.setText("O");
                        b7 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }
            }
        });
        botao8 = new JButton();
        botao8.setBackground(new Color(249,249,230));
        botao8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b8 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9))
                    {
                        botao8.setFont(new Font("Dialog",0,66));
                        botao8.setText("X");
                        b8 = 1;
                    }
                    else 
                    {
                        botao8.setFont(new Font("Dialog",0,66));
                        botao8.setText("O");
                        b8 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }
            }
        });
        botao9 = new JButton();
        botao9.setBackground(new Color(249,249,230));
        botao9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt)
            {
                if(b9 == -1)
                {
                    if((cont == 1) || (cont == 3) || (cont == 5) || (cont == 7) || (cont == 9)) 
                    {
                        botao9.setFont(new Font("Dialog",0,66));
                        botao9.setText("X");
                        b9 = 1;
                    }
                    else 
                    {
                        botao9.setFont(new Font("Dialog",0,66));
                        botao9.setText("O");
                        b9 = 0;
                    }
                    cont = cont + 1;
                    teste();
                    if(jogo == true){
                        novo();
                    }
                    if(comput == true)
                        computador();
                }
            }
        });
        
        painel = new JPanel();
        painel.setBackground(new Color(204,204,204));
        painel.setLayout(new GridLayout(3,0,3,0));
        painel.add(botao1);
        painel.add(botao2);
        painel.add(botao3);
        painel.add(botao4);
        painel.add(botao5);
        painel.add(botao6);
        painel.add(botao7);
        painel.add(botao8);
        painel.add(botao9);
        painel.setBorder(BorderFactory.createEtchedBorder());
        getContentPane().add(painel, BorderLayout.CENTER);
    }   
    

/*------------------------------------------------------------------------------------------------------*/
            // Testa para ver houve algum vencedor 
/*------------------------------------------------------------------------------------------------------*/
    public void teste()
    {    
        for(int a = 0; a < 2; a++) 
        {
                if((b1 == a)&&(b2 == a)&&(b3 == a))
                {
                    jogo = true;
                    c = a;
                    break;
                }
                if((b4 == a)&&(b5 == a)&&(b6 == a))
                {
                    jogo = true;
                    c = a;
                    break;
                }
                if((b7 == a)&&(b8 == a)&&(b9 == a))
                {
                    jogo = true;
                    c = a;
                    break;
                }
                if((b1 == a)&&(b4 == a)&&(b7 == a)) 
                {
                    jogo = true;
                    c = a;
                    break;
                }
                if((b2 == a)&&(b5 == a)&&(b8 == a))
                {
                    jogo = true;
                    c = a;
                    break;
                }
                if((b3 == a)&&(b6 == a)&&(b9 == a))
                {
                    jogo = true;
                    c = a;
                    break;
                }
                if((b1 == a)&&(b5 == a)&&(b9 == a))
                {
                    jogo = true;
                    c = a;
                    break;
                }
                if((b3 == a)&&(b5 == a)&&(b7 == a))
                {
                    jogo = true;
                    c = a;
                    break;
                }
        }
        if(jogo == true) // Se houve algum vencedor jogo recebe true
        {
            if(c == 0) {
                    JOptionPane.showMessageDialog(null, "O Ganhou", "Jogo da Velha", JOptionPane.INFORMATION_MESSAGE);
                    novo();
            }
            else {
                    JOptionPane.showMessageDialog(null, "X Ganhou", "Jogo da Velha", JOptionPane.INFORMATION_MESSAGE);
                    novo();
            }            
        }
        else if((jogo == false)&&(cont > 9)) // se nao houve da empate
        {
            JOptionPane.showMessageDialog(null, "Deu Velha", "Jogo da Velha", JOptionPane.INFORMATION_MESSAGE);
            novo();
        }              
    }
    
    
/*------------------------------------------------------------------------------------------------------*/
            // implementa a jogada do computador
/*------------------------------------------------------------------------------------------------------*/
    public void computador()
    {    
            if(computf == true)
            {
                if(comp == 0)
                {
                    if(b5 == -1)
                    {
                        botao5.setFont(new Font("Dialog",0,66));
                        botao5.setText("O");
                        b5 = 0;
                        cont = cont + 1;
                        comp = 1;
                        teste(); 
                        if(jogo == true){
                            novo();
                        }                   
                    }
                    else
                    {
                        botao1.setFont(new Font("Dialog",0,66));
                        botao1.setText("O");
                        b1 = 0;
                        cont = cont + 1;
                        comp = 1;
                        teste();
                        if(jogo == true){
                            novo();
                        }
                    }
                }
                else
                {
                    testaseganho(); 
                    comfacil(); 
                }    
            }
            else if(computm == true)
            {
                if(comp == 0)
                {
                    if(b5 == -1)
                    {
                        botao5.setFont(new Font("Dialog",0,66));
                        botao5.setText("O");
                        b5 = 0;
                        cont = cont + 1;
                        comp = 1;
                        teste();
                        if(jogo == true){
                            novo();
                        }                    
                    }
                    else
                    {
                        botao1.setFont(new Font("Dialog",0,66));
                        botao1.setText("O");
                        b1 = 0;
                        cont = cont + 1;
                        comp = 1;
                        teste();
                        if(jogo == true){
                            novo();
                        }
                    }
                }
                else
                {
                    testaseganho();
                    commedio();
                }    
            }
            else if(computd == true)
            {
                if(comp == 0)
                {
                    if(b5 == -1)
                    {
                        botao5.setFont(new Font("Dialog",0,66));
                        botao5.setText("O");
                        b5 = 0;
                        cont = cont + 1;
                        comp = 1;
                        teste();
                        if(jogo == true){
                            novo();
                        }                    
                    }
                    else
                    {
                        botao1.setFont(new Font("Dialog",0,66));
                        botao1.setText("O");
                        b1 = 0;
                        cont = cont + 1;
                        comp = 1;
                        teste();
                        if(jogo == true){
                            novo();
                        }
                    }
                }
                else
                {
                    testaseganho();
                    comdifi();
                }    
            }
        
    }
    
    
/*------------------------------------------------------------------------------------------------------*/
            //testa se computador pode ganhar
/*------------------------------------------------------------------------------------------------------*/
    public void testaseganho()
    {
        if(((b1 == 0)&&(b2 == 0)&&(b3 == -1)) || ((b6 == 0)&&(b9 == 0)&&(b3 == -1)) ||((b7 == 0)&&(b5 == 0)&&(b3 == -1)))
        {
            botao3.setFont(new Font("Dialog",0,66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b5 == 0)&&(b8 == 0)&&(b2 == -1)) || ((b1 == 0)&&(b3 == 0)&&(b2 == -1)))
        {
            botao2.setFont(new Font("Dialog",0,66));
            botao2.setText("O");
            b2 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == 0)&&(b3 == 0)) || ((b7 == 0)&&(b4 == 0)&&(b1 == -1)) ||((b9 == 0)&&(b5 == 0)&&(b1 == -1)))
        {
            botao1.setFont(new Font("Dialog",0,66));
            botao1.setText("O");
            b1 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 0)&&(b7 == 0)&&(b4 == -1)) || ((b6 == 0)&&(b5 == 0)&&(b4 == -1)))
        {
            botao4.setFont(new Font("Dialog",0,66));
            botao4.setText("O");
            b4 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b2 == 0)&&(b8 == 0)&&(b5 == -1)) || ((b4 == 0)&&(b6 == 0)&&(b5 == -1)) ||((b7 == 0)&&(b3 == 0)&&(b5 == -1)) || ((b1 == 0)&&(b9 == 0)&&(b5 == -1)))
        {
            botao5.setFont(new Font("Dialog",0,66));
            botao5.setText("O");
            b5 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b4 == 0)&&(b5 == 0)&&(b6 == -1)) || ((b3 == 0)&&(b9 == 0)&&(b6 == -1)))
        {
            botao6.setFont(new Font("Dialog",0,66));
            botao6.setText("O");
            b6 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 0)&&(b4 == 0)&&(b7 == -1)) || ((b3 == 0)&&(b5 == 0)&&(b7 == -1)) ||((b9 == 0)&&(b8 == 0)&&(b7 == -1)))
        {
            botao7.setFont(new Font("Dialog",0,66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 0)&&(b9 == 0)&&(b8 == -1)) || ((b2 == 0)&&(b5 == 0)&&(b8 == -1)))
        {
            botao8.setFont(new Font("Dialog",0,66));
            botao8.setText("O");
            b8 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 0)&&(b8 == 0)&&(b9 == -1)) || ((b1 == 0)&&(b5 == 0)&&(b9 == -1)) ||((b3 == 0)&&(b6 == 0)&&(b9 == -1)))
        {
            botao9.setFont(new Font("Dialog",0,66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
    }
    
    
 /*------------------------------------------------------------------------------------------------------*/
            // Joga nas posicoes no nivel dificil
 /*------------------------------------------------------------------------------------------------------*/
    public void comdifi()
    {
        if((b1 == 1)&&(b2 == -1)&&(b3 == -1) && (b4 == -1)&&(b5 == 0)&&(b6 == 1) && (b7 == -1)&&(b8 == -1)&&(b9 == -1))
        {
            botao3.setFont(new Font("Dialog", 0, 66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if((b1 == 1)&&(b2 == -1)&&(b3 == -1) && (b4 == -1)&&(b5 == 0)&&(b6 == -1) && (b7 == -1)&&(b8 == 1)&&(b9 == -1))
        {
            botao7.setFont(new Font("Dialog", 0, 66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if((b1 == -1)&&(b2 == -1)&&(b3 == 1) && (b4 == -1)&&(b5 == 0)&&(b6 == -1) && (b7 == -1)&&(b8 == 1)&&(b9 == -1))
        {
            botao9.setFont(new Font("Dialog", 0, 66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 1)&&(b2 == 1)&&(b3 == -1)) || ((b6 == 1)&&(b9 == 1)&&(b3 == -1)) ||((b7 == 1)&&(b5 == 1)&&(b3 == -1)))
        {
            botao3.setFont(new Font("Dialog",0,66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b5 == 1)&&(b8 == 1)&&(b2 == -1)) || ((b1 == 1)&&(b3 == 1)&&(b2 == -1)))
        {
            botao2.setFont(new Font("Dialog",0,66));
            botao2.setText("O");
            b2 = 0;
            cont = cont + 1;
            teste();
        }
        else if(((b1 == -1)&&(b2 == 1)&&(b3 == 1)) || ((b7 == 1)&&(b4 == 1)&&(b1 == -1)) ||((b9 == 1)&&(b5 == 1)&&(b1 == -1)))
        {
            botao1.setFont(new Font("Dialog",0,66));
            botao1.setText("O");
            b1 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 1)&&(b7 == 1)&&(b4 == -1)) || ((b6 == 1)&&(b5 == 1)&&(b4 == -1)))
        {
            botao4.setFont(new Font("Dialog",0,66));
            botao4.setText("O");
            b4 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b2 == 1)&&(b8 == 1)&&(b5 == -1)) || ((b4 == 1)&&(b6 == 1)&&(b5 == -1)) ||((b7 == 1)&&(b3 == 1)&&(b5 == -1)) || ((b1 == 1)&&(b9 == 1)&&(b5 == -1)))
        {
            botao5.setFont(new Font("Dialog",0,66));
            botao5.setText("O");
            b5 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b4 == 1)&&(b5 == 1)&&(b6 == -1)) || ((b3 == 1)&&(b9 == 1)&&(b6 == -1)))
        {
            botao6.setFont(new Font("Dialog",0,66));
            botao6.setText("O");
            b6 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 1)&&(b4 == 1)&&(b7 == -1)) || ((b3 == 1)&&(b5 == 1)&&(b7 == -1)) ||((b9 == 1)&&(b8 == 1)&&(b7 == -1)))
        {
            botao7.setFont(new Font("Dialog",0,66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 1)&&(b9 == 1)&&(b8 == -1)) || ((b2 == 1)&&(b5 == 1)&&(b8 == -1)))
        {
            botao8.setFont(new Font("Dialog",0,66));
            botao8.setText("O");
            b8 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 1)&&(b8 == 1)&&(b9 == -1)) || ((b1 == 1)&&(b5 == 1)&&(b9 == -1)) ||((b3 == 1)&&(b6 == 1)&&(b9 == -1)))
        {
            botao9.setFont(new Font("Dialog",0,66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }   
        else if((b1 == -1)&& (b2 == -1) && (b3 == -1) && (b4 == -1) && (b5 == 0) && (b6 == 1) && (b7 == -1) && (b8 == 1) && (b9 == -1))
        {
            botao9.setFont(new Font("Dialog",0,66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if((b1 == -1)&& (b2 == 1) && (b3 == -1) && (b4 == -1) && (b5 == 0) && (b6 == 1) && (b7 == -1) && (b8 == -1) && (b9 == -1))
        {
            botao3.setFont(new Font("Dialog", 0, 66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if((b1 == -1)&& (b2 == -1) && (b3 == -1) && (b4 == 1) && (b5 == 0) && (b6 == -1) && (b7 == -1) && (b8 == 1) && (b9 == -1))
        {
            botao7.setFont(new Font("Dialog", 0, 66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
	else if((b1 == 0)&& (b2 == -1) && (b3 == -1) && (b4 == -1) && (b5 == 1) && (b6 == -1) && (b7 == -1) && (b8 == -1) && (b9 == 1))
        {
            botao3.setFont(new Font("Dialog", 0, 66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == -1)&&(b3 == 0)) || ((b1 == 0)&&(b2 == -1)&&(b3 == -1)) ||((b8 == -1)&&(b5 == 0)&&(b2 == -1)) || ((b8 == 0) &&(b5 == -1) && (b2 == -1)))
        {
            botao2.setFont(new Font("Dialog",0,66));
            botao2.setText("O");
            b2 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == -1)&&(b3 == 0)) || ((b1 == -1)&&(b2 == 0)&&(b3 == -1)) ||((b1 == -1)&&(b4 == 0)&&(b7 == -1)) || ((b1 == -1) &&(b4 == -1) && (b7 == 0)) || ((b1 == -1) &&(b5 == -1) && (b9 == 0)) || ((b1 == -1) &&(b5 == 0) && (b9 == -1)))
        {
            botao1.setFont(new Font("Dialog",0,66));
            botao1.setText("O");
            b1 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == 0)&&(b3 == -1)) || ((b1 == 0)&&(b2 == -1)&&(b3 == -1)) ||((b9 == -1)&&(b6 == 0)&&(b3 == -1)) || ((b9 == 0) &&(b6 == -1) && (b3 == -1)) || ((b7 == -1) &&(b5 == 0) && (b3 == -1)) || ((b7 == 0) &&(b5 == -1) && (b3 == -1)))
        {
            botao3.setFont(new Font("Dialog",0,66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b7 == 0)&&(b4 == -1)) || ((b1 == 0)&&(b7 == -1)&&(b4 == -1)) ||((b6 == -1)&&(b5 == 0)&&(b4 == -1)) || ((b6 == 0) &&(b5 == -1) && (b4 == -1)))
        {
            botao4.setFont(new Font("Dialog",0,66));
            botao4.setText("O");
            b4 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b5 == -1)&&(b9 == 0)) || ((b1 == 0)&&(b9 == -1)&&(b5 == -1)) ||((b3 == -1)&&(b7 == 0)&&(b5 == -1)) || ((b7 == -1) &&(b5 == -1) && (b3 == 0)) || ((b2 == -1) &&(b5 == -1) && (b8 == 0)) || ((b8 == -1) &&(b2 == 0) && (b5 == -1)) || ((b4 == -1) && (b5 == -1) && (b6 == 0)) || ((b4 == 0) && (b5 == -1) && (b6 == -1)))
        {
            botao5.setFont(new Font("Dialog",0,66));
            botao5.setText("O");
            b5 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b3 == -1)&&(b6 == -1)&&(b9 == 0)) || ((b9 == -1)&&(b3 == 0)&&(b6 == -1)) ||((b5 == -1)&&(b4 == 0)&&(b6 == -1)) || ((b4 == -1) &&(b5 == 0) && (b6 == -1)))
        {
            botao6.setFont(new Font("Dialog",0,66));
            botao6.setText("O");
            b6 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b7 == -1)&&(b4 == 0)) || ((b7 == -1)&&(b1 == 0)&&(b4 == -1)) ||((b3 == -1)&&(b5 == 0)&&(b7 == -1)) || ((b5 == -1) &&(b7 == -1) && (b3 == 0)) || ((b7 == -1) &&(b8 == -1) && (b9 == 0)) || ((b7 == -1) &&(b8 == 0) && (b9 == -1)))
        {
            botao7.setFont(new Font("Dialog",0,66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == -1)&&(b8 == -1)&&(b9 == 0)) || ((b8 == -1)&&(b7 == 0)&&(b9 == -1)) ||((b8 == -1)&&(b5 == 0)&&(b2 == -1)) || ((b8 == -1) &&(b5 == -1) && (b2 == 0)))
        {
            botao8.setFont(new Font("Dialog",0,66));
            botao8.setText("O");
            b8 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b9 == -1)&&(b5 == 0)) || ((b9 == -1)&&(b1 == 0)&&(b5 == -1)) ||((b3 == -1)&&(b6 == 0)&&(b9 == -1)) || ((b6 == -1) &&(b9 == -1) && (b3 == 0)) || ((b7 == -1) &&(b9 == -1) && (b7 == 0)) || ((b9 == -1) &&(b8 == 0) && (b7 == -1)))
        {
            botao9.setFont(new Font("Dialog",0,66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else
        {
          if(comput == true)
          {    
            if(b1 == -1) {
                botao1.setFont(new Font("Dialog",0,66));
                botao1.setText("O");
                b1 = 0;
                cont = cont + 1;
            }
            else if(b2 == -1) {
                botao2.setFont(new Font("Dialog",0,66));
                botao2.setText("O");
                b2 = 0;
                cont = cont + 1;
            }
            else if(b3 == -1) {
                botao3.setFont(new Font("Dialog",0,66));
                botao3.setText("O");
                b3 = 0;
                cont = cont + 1;
            }
            else if(b4 == -1) {
                botao4.setFont(new Font("Dialog",0,66));
                botao4.setText("O");
                b4 = 0;
                cont = cont + 1;
            }
            else if(b5 == -1) {
                botao5.setFont(new Font("Dialog",0,66));
                botao5.setText("O");
                b5 = 0;
                cont = cont + 1;
            }
            else if(b6 == -1) {
                botao6.setFont(new Font("Dialog",0,66));
                botao6.setText("O");
                b6 = 0;
                cont = cont + 1;
            }
            else if(b7 == -1) {
                botao7.setFont(new Font("Dialog",0,66));
                botao7.setText("O");
                b7 = 0;
                cont = cont + 1;
            }
            else if(b8 == -1) {
                botao8.setFont(new Font("Dialog",0,66));
                botao8.setText("O");
                b8 = 0;
                cont = cont + 1;
            }
            else if(b9 == -1) {
                botao9.setFont(new Font("Dialog",0,66));
                botao9.setText("O");
                b9 = 0;
                cont = cont + 1;
            }
          }  
        } 
    }
    
 
 /*------------------------------------------------------------------------------------------------------*/
            // Joga nas posicoes no nivel facil
 /*------------------------------------------------------------------------------------------------------*/
    public void comfacil()
    {    
        if(((b1 == 1)&&(b2 == 1)&&(b3 == -1)) || ((b6 == 1)&&(b9 == 1)&&(b3 == -1)) ||((b7 == 1)&&(b5 == 1)&&(b3 == -1)))
        {
            botao3.setFont(new Font("Dialog",0,66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b5 == 1)&&(b8 == 1)&&(b2 == -1)) || ((b1 == 1)&&(b3 == 1)&&(b2 == -1)))
        {
            botao2.setFont(new Font("Dialog",0,66));
            botao2.setText("O");
            b2 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == 1)&&(b3 == 1)) || ((b7 == 1)&&(b4 == 1)&&(b1 == -1)))
        {
            botao1.setFont(new Font("Dialog",0,66));
            botao1.setText("O");
            b1 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 1)&&(b7 == 1)&&(b4 == -1)) || ((b6 == 1)&&(b5 == 1)&&(b4 == -1)))
        {
            botao4.setFont(new Font("Dialog",0,66));
            botao4.setText("O");
            b4 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b4 == 1)&&(b6 == 1)&&(b5 == -1)) ||((b7 == 1)&&(b3 == 1)&&(b5 == -1)) || ((b1 == 1)&&(b9 == 1)&&(b5 == -1)))
        {
            botao5.setFont(new Font("Dialog",0,66));
            botao5.setText("O");
            b5 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b4 == 1)&&(b5 == 1)&&(b6 == -1)) || ((b3 == 1)&&(b9 == 1)&&(b6 == -1)))
        {
            botao6.setFont(new Font("Dialog",0,66));
            botao6.setText("O");
            b6 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 1)&&(b4 == 1)&&(b7 == -1)) || ((b3 == 1)&&(b5 == 1)&&(b7 == -1)))
        {
            botao7.setFont(new Font("Dialog",0,66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 1)&&(b9 == 1)&&(b8 == -1)) || ((b2 == 1)&&(b5 == 1)&&(b8 == -1)))
        {
            botao8.setFont(new Font("Dialog",0,66));
            botao8.setText("O");
            b8 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 1)&&(b8 == 1)&&(b9 == -1)) || ((b1 == 1)&&(b5 == 1)&&(b9 == -1)))
        {
            botao9.setFont(new Font("Dialog",0,66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }        
        else
        {
          if(comput == true)
          {  
            if(b1 == -1) {
                botao1.setFont(new Font("Dialog",0,66));
                botao1.setText("O");
                b1 = 0;
                cont = cont + 1;
            }
            else if(b2 == -1) {
                botao2.setFont(new Font("Dialog",0,66));
                botao2.setText("O");
                b2 = 0;
                cont = cont + 1;
            }
            else if(b3 == -1) {
                botao3.setFont(new Font("Dialog",0,66));
                botao3.setText("O");
                b3 = 0;
                cont = cont + 1;
            }
            else if(b4 == -1) {
                botao4.setFont(new Font("Dialog",0,66));
                botao4.setText("O");
                b4 = 0;
                cont = cont + 1;
            }
            else if(b5 == -1) {
                botao5.setFont(new Font("Dialog",0,66));
                botao5.setText("O");
                b5 = 0;
                cont = cont + 1;
            }
            else if(b6 == -1) {
                botao6.setFont(new Font("Dialog",0,66));
                botao6.setText("O");
                b6 = 0;
                cont = cont + 1;
            }
            else if(b7 == -1) {
                botao7.setFont(new Font("Dialog",0,66));
                botao7.setText("O");
                b7 = 0;
                cont = cont + 1;
            }
            else if(b8 == -1) {
                botao8.setFont(new Font("Dialog",0,66));
                botao8.setText("O");
                b8 = 0;
                cont = cont + 1;
            }
            else if(b9 == -1) {
                botao9.setFont(new Font("Dialog",0,66));
                botao9.setText("O");
                b9 = 0;
                cont = cont + 1;
            }
          } 
        }
    }
      
    
    
 /*------------------------------------------------------------------------------------------------------*/
            // Joga nas posicoes no nivel medio
 /*------------------------------------------------------------------------------------------------------*/
    public void commedio()
    {    
        if(((b1 == 1)&&(b2 == 1)&&(b3 == -1)) || ((b6 == 1)&&(b9 == 1)&&(b3 == -1)) ||((b7 == 1)&&(b5 == 1)&&(b3 == -1)))
        {
            botao3.setFont(new Font("Dialog",0,66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b5 == 1)&&(b8 == 1)&&(b2 == -1)) || ((b1 == 1)&&(b3 == 1)&&(b2 == -1)))
        {
            botao2.setFont(new Font("Dialog",0,66));
            botao2.setText("O");
            b2 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == 1)&&(b3 == 1)) || ((b7 == 1)&&(b4 == 1)&&(b1 == -1)) ||((b9 == 1)&&(b5 == 1)&&(b1 == -1)))
        {
            botao1.setFont(new Font("Dialog",0,66));
            botao1.setText("O");
            b1 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 1)&&(b7 == 1)&&(b4 == -1)) || ((b6 == 1)&&(b5 == 1)&&(b4 == -1)))
        {
            botao4.setFont(new Font("Dialog",0,66));
            botao4.setText("O");
            b4 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b2 == 1)&&(b8 == 1)&&(b5 == -1)) || ((b4 == 1)&&(b6 == 1)&&(b5 == -1)) ||((b7 == 1)&&(b3 == 1)&&(b5 == -1)) || ((b1 == 1)&&(b9 == 1)&&(b5 == -1)))
        {
            botao5.setFont(new Font("Dialog",0,66));
            botao5.setText("O");
            b5 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b4 == 1)&&(b5 == 1)&&(b6 == -1)) || ((b3 == 1)&&(b9 == 1)&&(b6 == -1)))
        {
            botao6.setFont(new Font("Dialog",0,66));
            botao6.setText("O");
            b6 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == 1)&&(b4 == 1)&&(b7 == -1)) || ((b3 == 1)&&(b5 == 1)&&(b7 == -1)) ||((b9 == 1)&&(b8 == 1)&&(b7 == -1)))
        {
            botao7.setFont(new Font("Dialog",0,66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 1)&&(b9 == 1)&&(b8 == -1)) || ((b2 == 1)&&(b5 == 1)&&(b8 == -1)))
        {
            botao8.setFont(new Font("Dialog",0,66));
            botao8.setText("O");
            b8 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == 1)&&(b8 == 1)&&(b9 == -1)) || ((b1 == 1)&&(b5 == 1)&&(b9 == -1)) ||((b3 == 1)&&(b6 == 1)&&(b9 == -1)))
        {
            botao9.setFont(new Font("Dialog",0,66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }   
        else if((b1 == -1)&& (b2 == -1) && (b3 == -1) && (b4 == -1) && (b5 == 0) && (b6 == 1) && (b7 == -1) && (b8 == 1) && (b9 == -1))
        {
                botao1.setFont(new Font("Dialog",0,66));
                botao1.setText("O");
                b1 = 0;
                cont = cont + 1;
                teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == -1)&&(b3 == 0)) || ((b1 == 0)&&(b2 == -1)&&(b3 == -1)) ||((b8 == -1)&&(b5 == 0)&&(b2 == -1)) || ((b8 == 0) &&(b5 == -1) && (b2 == -1)))
        {
            botao2.setFont(new Font("Dialog",0,66));
            botao2.setText("O");
            b2 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == -1)&&(b3 == 0)) || ((b1 == -1)&&(b2 == 0)&&(b3 == -1)) ||((b1 == -1)&&(b4 == 0)&&(b7 == -1)) || ((b1 == -1) &&(b4 == -1) && (b7 == 0)) || ((b1 == -1) &&(b5 == -1) && (b9 == 0)) || ((b1 == -1) &&(b5 == 0) && (b9 == -1)))
        {
            botao1.setFont(new Font("Dialog",0,66));
            botao1.setText("O");
            b1 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b2 == 0)&&(b3 == -1)) || ((b1 == 0)&&(b2 == -1)&&(b3 == -1)) ||((b9 == -1)&&(b6 == 0)&&(b3 == -1)) || ((b9 == 0) &&(b6 == -1) && (b3 == -1)) || ((b7 == -1) &&(b5 == 0) && (b3 == -1)) || ((b7 == 0) &&(b5 == -1) && (b3 == -1)))
        {
            botao3.setFont(new Font("Dialog",0,66));
            botao3.setText("O");
            b3 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b7 == 0)&&(b4 == -1)) || ((b1 == 0)&&(b7 == -1)&&(b4 == -1)) ||((b6 == -1)&&(b5 == 0)&&(b4 == -1)) || ((b6 == 0) &&(b5 == -1) && (b4 == -1)))
        {
            botao4.setFont(new Font("Dialog",0,66));
            botao4.setText("O");
            b4 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b5 == -1)&&(b9 == 0)) || ((b1 == 0)&&(b9 == -1)&&(b5 == -1)) ||((b3 == -1)&&(b7 == 0)&&(b5 == -1)) || ((b7 == -1) &&(b5 == -1) && (b3 == 0)) || ((b2 == -1) &&(b5 == -1) && (b8 == 0)) || ((b8 == -1) &&(b2 == 0) && (b5 == -1)) || ((b4 == -1) && (b5 == -1) && (b6 == 0)) || ((b4 == 0) && (b5 == -1) && (b6 == -1)))
        {
            botao5.setFont(new Font("Dialog",0,66));
            botao5.setText("O");
            b5 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b3 == -1)&&(b6 == -1)&&(b9 == 0)) || ((b9 == -1)&&(b3 == 0)&&(b6 == -1)) ||((b5 == -1)&&(b4 == 0)&&(b6 == -1)) || ((b4 == -1) &&(b5 == 0) && (b6 == -1)))
        {
            botao6.setFont(new Font("Dialog",0,66));
            botao6.setText("O");
            b6 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b7 == -1)&&(b4 == 0)) || ((b7 == -1)&&(b1 == 0)&&(b4 == -1)) ||((b3 == -1)&&(b5 == 0)&&(b7 == -1)) || ((b5 == -1) &&(b7 == -1) && (b3 == 0)) || ((b7 == -1) &&(b8 == -1) && (b9 == 0)) || ((b7 == -1) &&(b8 == 0) && (b9 == -1)))
        {
            botao7.setFont(new Font("Dialog",0,66));
            botao7.setText("O");
            b7 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b7 == -1)&&(b8 == -1)&&(b9 == 0)) || ((b8 == -1)&&(b7 == 0)&&(b9 == -1)) ||((b8 == -1)&&(b5 == 0)&&(b2 == -1)) || ((b8 == -1) &&(b5 == -1) && (b2 == 0)))
        {
            botao8.setFont(new Font("Dialog",0,66));
            botao8.setText("O");
            b8 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else if(((b1 == -1)&&(b9 == -1)&&(b5 == 0)) || ((b9 == -1)&&(b1 == 0)&&(b5 == -1)) ||((b3 == -1)&&(b6 == 0)&&(b9 == -1)) || ((b6 == -1) &&(b9 == -1) && (b3 == 0)) || ((b7 == -1) &&(b9 == -1) && (b7 == 0)) || ((b9 == -1) &&(b8 == 0) && (b7 == -1)))
        {
            botao9.setFont(new Font("Dialog",0,66));
            botao9.setText("O");
            b9 = 0;
            cont = cont + 1;
            teste();
            if(jogo == true){
                novo();
            }
        }
        else
        {
          if(comput == true)
          {    
            if(b1 == -1) {
                botao1.setFont(new Font("Dialog",0,66));
                botao1.setText("O");
                b1 = 0;
                cont = cont + 1;
            }
            else if(b2 == -1) {
                botao2.setFont(new Font("Dialog",0,66));
                botao2.setText("O");
                b2 = 0;
                cont = cont + 1;
            }
            else if(b3 == -1) {
                botao3.setFont(new Font("Dialog",0,66));
                botao3.setText("O");
                b3 = 0;
                cont = cont + 1;
            }
            else if(b4 == -1) {
                botao4.setFont(new Font("Dialog",0,66));
                botao4.setText("O");
                b4 = 0;
                cont = cont + 1;
            }
            else if(b5 == -1) {
                botao5.setFont(new Font("Dialog",0,66));
                botao5.setText("O");
                b5 = 0;
                cont = cont + 1;
            }
            else if(b6 == -1) {
                botao6.setFont(new Font("Dialog",0,66));
                botao6.setText("O");
                b6 = 0;
                cont = cont + 1;
            }
            else if(b7 == -1) {
                botao7.setFont(new Font("Dialog",0,66));
                botao7.setText("O");
                b7 = 0;
                cont = cont + 1;
            }
            else if(b8 == -1) {
                botao8.setFont(new Font("Dialog",0,66));
                botao8.setText("O");
                b8 = 0;
                cont = cont + 1;
            }
            else if(b9 == -1) {
                botao9.setFont(new Font("Dialog",0,66));
                botao9.setText("O");
                b9 = 0;
                cont = cont + 1;
            }
          }  
        }
    }
    
 
 /*------------------------------------------------------------------------------------------------------*/
            // implementacao do window listener
 /*------------------------------------------------------------------------------------------------------*/
    public void windowClosing(WindowEvent e) {
		System.exit(0);
    }
    public void windowOpened(WindowEvent e)  {  }
    public void windowIconified(WindowEvent e)  {  }
    public void windowDeiconified(WindowEvent e)  {  }
    public void windowClosed(WindowEvent e)  {  }
    public void windowDeactivated(WindowEvent e)  {  }
    public void windowActivated(WindowEvent e)  {  }


 /*------------------------------------------------------------------------------------------------------*/
            // Cria um novo jogo
 /*------------------------------------------------------------------------------------------------------*/
    public void novo()
    {
        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = -1; // seta todos os botoes como -1
        cont = 1;
        comp = 0;
        comput = false;
        computf = false;
        computm = false;
        computd = false;
        facil.setSelected(false);
        medio.setSelected(false);
        dificil.setSelected(false);
        jogo = false;
        botao1.setText(" ");
        botao2.setText(" ");
        botao3.setText(" ");
        botao4.setText(" ");
        botao5.setText(" ");
        botao6.setText(" ");
        botao7.setText(" ");
        botao8.setText(" ");
        botao9.setText(" ");
    }
    
 /*------------------------------------------------------------------------------------------------------*/
            // Metodo Main: Metodo inicial
 /*------------------------------------------------------------------------------------------------------*/
    public static void main(String args[]) {
        JVelha jv = new JVelha();  
        jv.setSize(400,400);
        jv.setTitle("Jogo da Velha"); 
        jv.setLocationRelativeTo(null);
        jv.setVisible(true);
    }   
}
