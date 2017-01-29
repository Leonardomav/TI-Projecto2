/*
Artur Duarte Coutinho
Leonardo Machado Alves Vieira 
Tiago Miguel Vitorino Simões Gomes
*/

package projetoti;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;

//classe para ler uma imagem e preparar a codifica��o no formato GIF
public class MyGIF  
{
	static short width, height;
	static byte [] r, g, b;
	static byte pixels[], colors[];
	
	public static void main(String args[])
	{
		if (args.length != 2) 
		{
			System.out.println("MyGIF <input file> <output file>");
			return;
		}
				
		try
		{		
			//---Carregar uma imagem
			String imName = args[0];
			Image image = ImageIO.read(new File(imName));
			
			//---Codificar a imagem como GIF		
			MyGIFEncoder encoder = new MyGIFEncoder(image);
		
			//---Escrever no ficheiro
			String gifName = args[1];
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(gifName));		
			
			////////////////////////////////////////////////////////
			encoder.write(output);			//---> COMPLETAR ESTA FUN��O
			////////////////////////////////////////////////////////				
		}
		catch(IOException e)
		{
			System.out.println("Erro no acesso ao ficheiro (input)");
			System.exit(-1);
		}
		catch(InterruptedException e)
		{
			System.out.println("Erro ao realizar o 'grabbing' dos pixeis");
			System.exit(-1);
		}
		catch(AWTException e)
		{
			System.out.println("Erro no acesso � imagem");
			System.exit(-1);
		}				
	}	
}