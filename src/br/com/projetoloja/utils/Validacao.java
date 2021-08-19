package br.com.projetoloja.utils;

public abstract class Validacao {
	public static String verificarSenha(String org, String conf) {
		
		System.out.println(org + "  -   "+ conf);
		
		String msg = "";
		if (!org.equals(conf))
			msg = "As senhas não são iguais";
		return msg;		
	}
	public static String verificarEmail(String email) {
		String msg = "";
		if( email.indexOf("@")== -1)
			msg = "E-Mail inválido.";
		return msg;
	}
}
