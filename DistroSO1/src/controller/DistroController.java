package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	public DistroController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		
		return os;
	}
	
	public void exibeDistro() {
		String os = os();
		
		if(os.contains("Windows")) {
			System.out.println("Este Sistema Operacional não é Linux");
		}else if(os.contains("Linux")){
			try {
				Process p = Runtime.getRuntime().exec("cat /etc/os-release");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha;
				
				while((linha= buffer.readLine()) != null) {
					System.out.println("Distribuição: " + linha.substring(13, linha.length() - 10));
					break;
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
