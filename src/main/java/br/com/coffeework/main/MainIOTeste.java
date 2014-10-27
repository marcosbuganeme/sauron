package br.com.coffeework.main;

import java.io.IOException;

import br.com.coffeework.util.criptografia.UtilCriptografia;

public class MainIOTeste {

	public static void main(String[] args) throws IOException {

		final String senhaCriptografada = UtilCriptografia.obterStringMD5("123456");
		
		System.out.println(senhaCriptografada);
		
		// NTSystem infoSystem = new NTSystem();
		// System.out.println(infoSystem.getName()); // username logado no windows/domínio
		// System.out.println(infoSystem.getDomain()); // nome do dominio do sistema windows

		// String usuario = System.getProperty("user.name");
		//
		// System.out.println(usuario);
		//
		// File file = new File("c:\\appSauron\\imagens");
		//
		// boolean diretorioExiste = file.mkdir();
		//
		// if (!diretorioExiste) {
		//
		// file.mkdirs();
		// }
		//
		// System.out.println(diretorioExiste);

//		String caminhoURL = "C:\\Users\\" + System.getProperty("user.name") + "\\Pictures\\appSauron\\fernanda.jpg";
//
//		Image image = null;
//		File sourceimage = new File(caminhoURL);
//		image = ImageIO.read(sourceimage);
//
//		image.getGraphics().create(5, 10, 200, 300);

	}

}
