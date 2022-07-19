
package interfaces;


import javax.swing.JOptionPane;
import controle.ControladorCadastroCliente;
//import controle.ControladorCadastroFilme;
//import controle.ControladorReserva;
import persistência.BD;

/**
 *
 * @author gabriel
 */
public class JanelaVideolocadora extends javax.swing.JFrame {

    
    public JanelaVideolocadora() {
        BD.criaConexão();
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        videolocadoraMenuBar = new javax.swing.JMenuBar();
        clienteMenu = new javax.swing.JMenu();
        cadastrar_clienteMenuItem = new javax.swing.JMenuItem();
        filmeMenu = new javax.swing.JMenu();
        cadastrar_filmeMenuItem = new javax.swing.JMenuItem();
        reservar_filmeMenuItem = new javax.swing.JMenuItem();
        cópia_filmeMenu = new javax.swing.JMenu();
        cadastrar_cópiaMenuItem = new javax.swing.JMenuItem();
        locarMenuItem = new javax.swing.JMenuItem();
        devolverMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Videolocadora Sétima Arte");

        clienteMenu.setText("Cliente");

        cadastrar_clienteMenuItem.setText("Cadastrar");
        cadastrar_clienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCliente(evt);
            }
        });
        clienteMenu.add(cadastrar_clienteMenuItem);

        videolocadoraMenuBar.add(clienteMenu);

        filmeMenu.setText("Filme");

        cadastrar_filmeMenuItem.setText("Cadastrar");
        cadastrar_filmeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFilme(evt);
            }
        });
        filmeMenu.add(cadastrar_filmeMenuItem);

        reservar_filmeMenuItem.setText("Reservar");
        reservar_filmeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarFilme(evt);
            }
        });
        filmeMenu.add(reservar_filmeMenuItem);

        videolocadoraMenuBar.add(filmeMenu);

        cópia_filmeMenu.setText("CópiaFilme");

        cadastrar_cópiaMenuItem.setText("Cadastrar");
        cadastrar_cópiaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarCópiaFilme(evt);
            }
        });
        cópia_filmeMenu.add(cadastrar_cópiaMenuItem);

        locarMenuItem.setText("Locar");
        locarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locarFilme(evt);
            }
        });
        cópia_filmeMenu.add(locarMenuItem);

        devolverMenuItem.setText("Devolver");
        devolverMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverFilme(evt);
            }
        });
        cópia_filmeMenu.add(devolverMenuItem);

        videolocadoraMenuBar.add(cópia_filmeMenu);

        setJMenuBar(videolocadoraMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void informaServiçoIndisponível() {
        JOptionPane.showMessageDialog (this, "Serviço Indisponível", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void terminarSistema(java.awt.event.WindowEvent evt) {
        BD.fechaConexão();
        System.exit(1);
    }

    private void cadastrarCliente(java.awt.event.ActionEvent evt) {
        new ControladorCadastroCliente ();
    }

    private void cadastrarCópiaFilme(java.awt.event.ActionEvent evt) {
        informaServiçoIndisponível ();
    }

    private void locarFilme(java.awt.event.ActionEvent evt) {
        informaServiçoIndisponível ();
    }

    private void devolverFilme(java.awt.event.ActionEvent evt) {
        informaServiçoIndisponível ();
    }

    private void cadastrarFilme(java.awt.event.ActionEvent evt) {
       informaServiçoIndisponível ();
    }

    private void reservarFilme(java.awt.event.ActionEvent evt) {
        informaServiçoIndisponível ();
    }

 

    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaVideolocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaVideolocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaVideolocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaVideolocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaVideolocadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cadastrar_clienteMenuItem;
    private javax.swing.JMenuItem cadastrar_cópiaMenuItem;
    private javax.swing.JMenuItem cadastrar_filmeMenuItem;
    private javax.swing.JMenu clienteMenu;
    private javax.swing.JMenu cópia_filmeMenu;
    private javax.swing.JMenuItem devolverMenuItem;
    private javax.swing.JMenu filmeMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem locarMenuItem;
    private javax.swing.JMenuItem reservar_filmeMenuItem;
    private javax.swing.JMenuBar videolocadoraMenuBar;
    // End of variables declaration//GEN-END:variables
}
