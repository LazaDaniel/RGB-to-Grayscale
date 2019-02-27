import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class Main{
	static void display(String... args) {
		System.out.println("Am folosit var args!");
	}

static public void main(String args[]) throws InterruptedException, IOException
{  
	if(args.length!=0) {display(args[0]);
	
	
		long startTime = System.nanoTime();
		String outputFilePath = null; //numele fisierului, declarat initial nul
		
	   GrayscalePicture obj = new GrayscalePicture();//se creeaza nou obiect de tipGreyscaleImage
	   
	   
	  
			outputFilePath = args[0];
			
			
		
							
		
	   
	   File output = new File(outputFilePath);
	   
	   ImageIO.write(obj.ConvertToGreyscale(args[1]), "bmp", output); //se apeleaza metoda de conversie 
	   
	   System.out.println("Conversie alb-negru reusita."); //notificare ca operatia de conversie s-a incheiat
	   
	   	long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //timpul de executie al metodei main
		System.out.println("Timp de executie: Main: " + totalTime/1000000000 + " secunde");	
	


		
	}
	
	
	
	
	
	
	
	
	if(args.length==0) {
		long startTime = System.nanoTime();
		String outputFilePath = null; //numele fisierului, declarat initial nul
		
	   GrayscalePicture obj = new GrayscalePicture();//se creeaza nou obiect de tipGreyscaleImage
	   
	   
	   try {
		 
			InputStreamReader isr = new InputStreamReader(System.in); //numele fisierului de iesire (in care este pastrata imaginea alb-negru) se citeste de la tastatura in acelasi mod ca fisierul de intrare
		    BufferedReader br = new BufferedReader(isr);
		    System.out.println("Introduceti numele/adresa fisierului in care se va salva noua imagine (extensie .bmp)");
			outputFilePath = (br.readLine()).toString();
			
			while (!outputFilePath.endsWith(".bmp"))
			{
				System.out.println("Fisierul nu are extensia potrivita."
						+ " Introduceti un nume de fisier cu extensia .bmp.");
				outputFilePath =  (br.readLine()).toString();
			}	
		}
							
		catch (IOException e)
		{
			System.out.println("Nu s-a realizat citirea numelui/adresei fisierului in mod corect");
		}
	   
	   File output = new File(outputFilePath);
	   
	   ImageIO.write(obj.ConvertToGreyscale(), "bmp", output); //se apeleaza metoda de conversie 
	   
	   System.out.println("Conversie alb-negru reusita."); //notificare ca operatia de conversie s-a incheiat
	   
	   	long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //timpul de executie al metodei main
		System.out.println("Timp de executie: Main: " + totalTime/1000000000 + " secunde");	
	


		}
	}
}

