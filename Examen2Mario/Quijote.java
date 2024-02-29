package Programacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class Quijote {
 
	public static void main(String[] args) {
		try {
			FileOutputStream fileout = new FileOutputStream("QUIJOTE_HASH.DAT");
			ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
			MessageDigest md = MessageDigest.getInstance("SHA");
			String datos = "En un lugar de la mancha de cuyo nombre no quiero acrodarme,\n"
					+" no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero,\n"
					+" adarga antigua, rocin flaco y galgo corredor. Una olla de algo más vaca\n"
					+" que carnero, salpicón las más noches, duelos y quebrantos los sabados,\n"
					+" lentejas los viernes, algún palomino de añadidura los domingos,\n"
					+" consumían las tres partes de su hacienda. El resto della concluían\n"
					+" sayo de velarte, calza de velludo para las fiestas con sus pantuflos\n"
					+" de lo mismo, y los días de entresemana se honraba con su vellorí de lo más fino";
			byte dataBytes[]=datos.getBytes();
			md.update(dataBytes);
			byte resumen[] = md.digest();
			dataOS.writeObject(datos);
			dataOS.writeObject(resumen);
			dataOS.close();
			fileout.close();
			System.out.println("Datos:" + datos);
			System.out.println("\nResumen creado con exito");
		}catch (IOException e) {e.printStackTrace();
	}catch(NoSuchAlgorithmException e) {e.printStackTrace();}
	
	}
}
