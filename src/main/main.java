/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

/**
 *
 * @author WIN 10
 */

public class main extends javax.swing.JFrame {

    private static final String LOWERCASE = "qwertyuiopasdfghjklzxcvbnm";
    private static final String UPPERCASE = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String NUMBER = "0123456789";
    private static final String SYMBOL = "#$%&=?*+-!";
    
    private javax.swing.JLabel loadingLabel;

    public static String generatepassword(int length, boolean useLower, boolean useUpper, boolean useNumbers, boolean useSymbols) {
        String characters = "";
        if (useLower) characters += LOWERCASE;
        if (useUpper) characters += UPPERCASE;
        if (useNumbers) characters += NUMBER;
        if (useSymbols) characters += SYMBOL;

        char[] password = new char[length];
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            int pos = random.nextInt(characters.length());
            password[i] = characters.charAt(pos);
        }
        return new String(password);
    }

    public main() {
        initComponents();
        pass.setText(generatepassword(8, true, true, true, true));
        
        addHoverEffect(jButton1, new Color(255, 182, 193), new Color(255, 105, 180));
        addHoverEffect(jButton2, new Color(135, 206, 250), new Color(30, 144, 255));
        
        // Crear JLabel de carga con un texto más visible
        loadingLabel = new javax.swing.JLabel("Cargando...");
        loadingLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));  // Fuente más grande y en negrita
        loadingLabel.setForeground(new java.awt.Color(255, 165, 0));  // Color anaranjado
        loadingLabel.setVisible(false);  // Inicialmente oculto
        getContentPane().add(loadingLabel);  // Agregar al panel

        // Cambiar las coordenadas de la posición de 'loadingLabel' para que esté por encima de la contraseña
        loadingLabel.setBounds(200, 200, 150, 30);  // Ajustamos la posición para que esté más arriba
    }
    
    private void addHoverEffect(javax.swing.JButton button, Color hoverColor, Color defaultColor) {
        button.setBackground(defaultColor);
        button.setFont(button.getFont().deriveFont(18f));

        button.addMouseListener(new MouseAdapter() {
            Timer timer;
            Color currentColor = defaultColor;
            float defaultFontSize = 18f;
            float hoverFontSize = 20f;
            Dimension defaultSize = new Dimension(button.getWidth(), button.getHeight());
            Dimension hoverSize = new Dimension(button.getWidth() + 10, button.getHeight() + 10);

            @Override
            public void mouseEntered(MouseEvent e) {
                timer = new Timer(10, evt -> {
                    currentColor = blendColors(currentColor, hoverColor, 0.1f);
                    button.setBackground(currentColor);
                    button.setPreferredSize(hoverSize);
                    button.setFont(button.getFont().deriveFont(hoverFontSize));
                    button.repaint();
                    if (currentColor.equals(hoverColor)) {
                        timer.stop();
                    }
                });
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }

                timer = new Timer(10, evt -> {
                    currentColor = blendColors(currentColor, defaultColor, 0.1f);
                    button.setBackground(currentColor);
                    button.setPreferredSize(defaultSize);
                    button.setFont(button.getFont().deriveFont(defaultFontSize));
                    button.repaint();
                    if (currentColor.equals(defaultColor)) {
                        timer.stop();
                    }
                });
                timer.start();
            }
        });
    }
    
    private Color blendColors(Color c1, Color c2, float ratio) {
        int red = (int) (c1.getRed() * (1 - ratio) + c2.getRed() * ratio);
        int green = (int) (c1.getGreen() * (1 - ratio) + c2.getGreen() * ratio);
        int blue = (int) (c1.getBlue() * (1 - ratio) + c2.getBlue() * ratio);
        return new Color(red, green, blue);
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pass = new javax.swing.JTextPane();
        msg = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        chkLower = new javax.swing.JCheckBox();
        chkUpper = new javax.swing.JCheckBox();
        chkNumbers = new javax.swing.JCheckBox();
        chkSymbols = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36));
        jLabel1.setText("Generador de Contraseñas");

        pass.setEditable(false);
        pass.setBackground(new java.awt.Color(255, 255, 255));
        pass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pass.setFont(new java.awt.Font("Sylfaen", 0, 18));
        jScrollPane1.setViewportView(pass);

        msg.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12));
        msg.setText("Longitud: 8");

        jSlider1.setBackground(new java.awt.Color(255, 0, 0));
        jSlider1.setMaximum(20);
        jSlider1.setMinimum(8);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(8);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

       jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18));
       jButton1.setText("Generar Nueva Contraseña");
       jButton1.setBorder(BorderFactory.createLineBorder(new Color(255, 105, 180)));
       jButton1.setBackground(new Color(255, 105, 180));
       jButton1.setForeground(Color.WHITE);
       jButton1.setFocusPainted(false); 
       jButton1.setOpaque(true);
       jButton1.addActionListener(new ActionListener()
       { public void actionPerformed(ActionEvent evt) { jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18));
        jButton2.setText("Copiar");
        jButton2.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255)));
        jButton2.setBackground(new Color(30, 144, 255)); jButton2.setForeground(Color.WHITE);
        jButton2.setFocusPainted(false); 
        jButton2.setOpaque(true);
        jButton2.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { jButton2ActionPerformed(evt);
            }
        });

        chkLower.setText("Letras Minúsculas");
        chkUpper.setText("Letras Mayúsculas");
        chkNumbers.setText("Números");
        chkSymbols.setText("Símbolos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(msg)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jButton1)))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkLower)
                    .addComponent(chkUpper)
                    .addComponent(chkNumbers)
                    .addComponent(chkSymbols))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkLower)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkUpper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkNumbers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSymbols)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
    
    private void ventana() {
        // Código generado previamente
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18));
        jButton1.setText("Generar Nueva Contraseña");
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(255, 105, 180)));
        jButton1.setFocusPainted(false);
        jButton1.setOpaque(true);

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18));
        jButton2.setText("Copiar");
        jButton2.setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255)));
        jButton2.setFocusPainted(false);
        jButton2.setOpaque(true);

        jSlider1.setMaximum(20);
        jSlider1.setMinimum(8);
        jSlider1.setValue(8);
        jSlider1.addChangeListener(evt -> {
            msg.setText("Longitud: " + jSlider1.getValue());
        });

        msg.setText("Longitud: 8");

        // Disposición del diseño omitida para mayor claridad

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        pass.setText(generatepassword(jSlider1.getValue(), chkLower.isSelected(), chkUpper.isSelected(), chkNumbers.isSelected(), chkSymbols.isSelected()));
    
    // Mostrar el indicador de carga
    loadingLabel.setVisible(true);
    
    // Generar la contraseña después de un retraso de 1 segundo
    new Timer(1000, e -> {
        // Generar la nueva contraseña
        pass.setText(generatepassword(jSlider1.getValue(), chkLower.isSelected(), chkUpper.isSelected(), chkNumbers.isSelected(), chkSymbols.isSelected()));
        
        // Ocultar el indicador de carga
        loadingLabel.setVisible(false);
        
        // Detener el Timer después de una ejecución
        ((Timer)e.getSource()).stop();
    }).start();
}                                 

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        pass.setText(generatepassword(jSlider1.getValue(), chkLower.isSelected(), chkUpper.isSelected(), chkNumbers.isSelected(), chkSymbols.isSelected()));
        msg.setText("Longitud: " + jSlider1.getValue());
    
        // Mostrar el indicador de carga mientras se genera la nueva contraseña
        loadingLabel.setVisible(true);

        new Timer(100, e -> {
            String passGenerated = generatepassword(jSlider1.getValue(), chkLower.isSelected(), chkUpper.isSelected(),
                    chkNumbers.isSelected(), chkSymbols.isSelected());
            pass.setText(passGenerated);

            // Ocultar el indicador de carga
            loadingLabel.setVisible(false);
        }).start();
    }                                     

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String password = pass.getText();
        StringSelection stringSelection = new StringSelection(password);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }                                        

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new main().setVisible(true);
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JCheckBox chkLower;
    private javax.swing.JCheckBox chkUpper;
    private javax.swing.JCheckBox chkNumbers;
    private javax.swing.JCheckBox chkSymbols;
    private javax.swing.JLabel msg;
    private javax.swing.JTextPane pass;
}













































/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pass = new javax.swing.JTextPane();
        msg = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel1.setText("password generator");

        pass.setEditable(false);
        pass.setBackground(new java.awt.Color(255, 255, 255));
        pass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pass.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(pass);

        msg.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        msg.setText("length: 8");

        jSlider1.setBackground(new java.awt.Color(255, 0, 0));
        jSlider1.setMaximum(20);
        jSlider1.setMinimum(8);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(8);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton1.setText("generate new password");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton2.setText("copy ");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(msg)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jButton1)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      

    }                                     

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel msg;
    private javax.swing.JTextPane pass;
    // End of variables declaration                   
*/