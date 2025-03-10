package view;
import javax.swing.*;
import java.awt.*;
public class TelaDevolucao extends JFrame {
	private JPanel painelPrincipal;
	private JTextField campoPlaca, campoCPF, campoDataDevolucao, campoValor;
	private JComboBox<String> comboPagamento;
	private JButton btnConfirmar, btnCancelar;
	public TelaDevolucao() {
        setTitle("Registro de Devolução");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridBagLayout());
        painelPrincipal.setBackground(new Color(28, 40, 51));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
  	    gbc.fill = GridBagConstraints.HORIZONTAL;
  	    JLabel titulo = new JLabel("Registro de Devolução");
  	    titulo.setForeground(Color.WHITE);
  	    titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
  	    JLabel lblPlaca = new JLabel("Placa do Veículo:");
  	    JLabel lblCPF = new JLabel("CPF do Cliente:");
  	    JLabel lblDataDevolucao = new JLabel("Data de Devolução:");
  	    JLabel lblValor = new JLabel("Valor Total:");
  	    JLabel lblPagamento = new JLabel("Forma de Pagamento:");
        lblPlaca.setForeground(Color.LIGHT_GRAY);
        lblCPF.setForeground(Color.LIGHT_GRAY);
        lblDataDevolucao.setForeground(Color.LIGHT_GRAY);
        lblValor.setForeground(Color.LIGHT_GRAY);
        lblPagamento.setForeground(Color.LIGHT_GRAY);
        campoPlaca = new JTextField(15);
        campoCPF = new JTextField(15);
        campoDataDevolucao = new JTextField(15);
        campoValor = new JTextField(15);
        comboPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Pix"});
        btnConfirmar = criarBotao("Confirmar", new Color(42, 157, 143));
        btnCancelar = criarBotao("Cancelar", Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painelPrincipal.add(titulo, gbc);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        painelPrincipal.add(lblPlaca, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoPlaca, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(lblCPF, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoCPF, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelPrincipal.add(lblDataDevolucao, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoDataDevolucao, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelPrincipal.add(lblValor, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(campoValor, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        painelPrincipal.add(lblPagamento, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(comboPagamento, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        painelPrincipal.add(btnConfirmar, gbc);
        gbc.gridx = 1;
        painelPrincipal.add(btnCancelar, gbc);
        add(painelPrincipal);
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
        SwingUtilities.invokeLater(() -> new TelaDevolucao().setVisible(true));
    }
}
