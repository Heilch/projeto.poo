package view;
import javax.swing.*;
import java.awt.*;

public class TelaAtendente extends JFrame {
	private JPanel painelPrincipal;
  
	public TelaAtendente() {
		setTitle("Painel do Atendente");
		setSize(400, 350);
       	setLocationRelativeTo(null);
       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	setResizable(false);
       	painelPrincipal = new JPanel();
       	painelPrincipal.setLayout(new GridBagLayout());
       	painelPrincipal.setBackground(new Color(28, 40, 51));
       	GridBagConstraints gbc = new GridBagConstraints();
       	gbc.insets = new Insets(5, 5, 5, 5);
       	gbc.fill = GridBagConstraints.HORIZONTAL;
       	JLabel titulo = new JLabel("Painel do Atendente");
       	titulo.setForeground(Color.WHITE);
       	titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
       	JButton btnRegistrarLocacao = criarBotao("Registrar Locação", new Color(42, 157, 143));
       	JButton btnRegistrarDevolucao = criarBotao("Registrar Devolução", new Color(42, 157, 143));
       	JButton btnSair = criarBotao("Sair", Color.RED);
        btnRegistrarLocacao.addActionListener(e -> abrirTelaRegistroLocacao());
        btnRegistrarDevolucao.addActionListener(e -> abrirTelaRegistroDevolucao());
        btnSair.addActionListener(e -> System.exit(0));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painelPrincipal.add(titulo, gbc);
        gbc.gridy = 1;
        painelPrincipal.add(btnRegistrarLocacao, gbc);
        gbc.gridy = 2;
        painelPrincipal.add(btnRegistrarDevolucao, gbc);
        gbc.gridy = 3;
        painelPrincipal.add(btnSair, gbc);
        add(painelPrincipal);
    }
    private void abrirTelaRegistroLocacao() {
        new TelaLocacao().setVisible(true);
        this.dispose();
    }
    private void abrirTelaRegistroDevolucao() {
        new TelaDevolucao().setVisible(true);
        this.dispose();
    }
    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setBackground(cor);
        botao.setForeground(Color.BLACK);
        botao.setFont(new Font("SansSerif", Font.BOLD, 14));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setPreferredSize(new Dimension(200, 35));
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(cor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(cor);
            }
        });
        return botao;
    }
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> new TelaAtendente().setVisible(true));
    }
}
