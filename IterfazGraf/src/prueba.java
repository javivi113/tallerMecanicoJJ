import java.util.Calendar;

import javax.swing.JOptionPane;



public class prueba {

	public static void main(String[] args) {
		System.out.println(checkAño(2022));
	}
	public static boolean esNumero(String num) {
		boolean numerico=true;
		try {
			//Sie el cambio da error saltara un error
			int numero=Integer.parseInt(num);
			//Al saltar la excepcion le dara false al boolean y devolvera que el valor
			//no es numerico

		} catch (NumberFormatException e) {
			numerico= false;
		}
		return numerico;

	}
	public static boolean checkDNI(String x) {
		int contador=0;
		String letrasValidas="AaBbCcDdEeFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz";
		if (x.length()==9) {
			String ultimaL=String.valueOf(x.charAt(x.length()-1));
			if (letrasValidas.contains(ultimaL)) {
				for (int i = 0; i < x.length(); i++)if (esNumero(String.valueOf(x.charAt(i))))contador++;
				if (contador==8)return true;
			}else {
				return false;
			}
		}
		return false;

	}
	public static boolean checkTlf(int tlf) {
		if (Integer.toString(tlf).length()==9) {
			return true;
		}
		return false;
	}
	public static boolean checkMail(String str) {
		String preArroba = null;
		String postArroba = null;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)=='@') {
				preArroba=str.substring(0,i);
				postArroba=str.substring(i+1,str.length());
			}			
		}
		String postArrobaPre = null, postArrobaPos = null;
		if (postArroba!=null) {
			for (int i = 0; i < postArroba.length(); i++) {
				if (postArroba.charAt(i)=='.') {
					postArrobaPre=str.substring(0,i);
					if (i!=postArroba.length()-1) {
						postArrobaPos=str.substring(i+1,postArroba.length());
					}
				}
				if (postArroba.charAt(i)=='@') {
					return false;
				}
			}
			if (postArrobaPos==null||postArrobaPre==null||preArroba==null) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}




	}
	public static boolean checkMatricula(String str) {
		if (str.length()==7) {
			String LetrasMatricula="BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz";
			String dijitos= str.substring(0,4);
			String letras=str.substring(4);
			try {
				int numeroMatricula=Integer.parseInt(dijitos);
			} catch (NumberFormatException e) {
				return false;
			}
			int contLetrasValidas=0;
			for (int i = 0; i < letras.length(); i++) {
				if (LetrasMatricula.contains(String.valueOf(letras.charAt(i))) ){
					contLetrasValidas++;
				}
			}
			if (contLetrasValidas==3) {
				return true;
			}else {
				return false;
			}

		}else if (str.length()==8) {
			String LetrasMatricula="BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz";
			String letraP=str.substring(0,2);
			String dijitos=str.substring(2,6);
			String letraF=str.substring(2,8);
			int contLetraValida=0;
			for (int i = 0; i < letraP.length(); i++) {
				if (LetrasMatricula.contains(String.valueOf(letraP.charAt(i))))contLetraValida++;
			}
			if (contLetraValida!=2)return false;
			try {
				int numeroMa=Integer.parseInt(dijitos);
			} catch (NumberFormatException e) {
				return false;
			}
			contLetraValida=0;
			for (int i = 0; i < letraF.length(); i++) {
				if (LetrasMatricula.contains(String.valueOf(letraF.charAt(i))))contLetraValida++;
			}
			if (contLetraValida!=2)return false;
			return true;
		}else {
			return false;
		}
	}
	public static boolean checkAño(int año) {
		Calendar fechaActual = Calendar.getInstance();
		int añoActual= fechaActual.get(Calendar.YEAR);
		if (año>añoActual) {
			return false;
		}
		return true;
	}




}
