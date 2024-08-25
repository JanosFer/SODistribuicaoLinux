package view;

import controller.DistroController;
import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		DistroController dc = new DistroController();
		
		int opc = 0;
		
		while(opc != 2) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Exibir nome e versão da distribuição Linux \n 2 - Sair"));
			switch(opc) {
				case 1:
					dc.exibeDistro();
					break;
				case 2:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}
	}
}