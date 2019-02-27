import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
//RealPicture este o clasa in care se vor implementa metodele necesare pentru citirea fisierului imagine. 
public class RealPicture extends Picture
{
	double width;
	double height;
	BufferedImage img;

	RealPicture() throws InterruptedException { //constructorul fara parametri al acestei clase va apela constructorul clasei parinte (Picture), realizand mostenirea
		super();
	}
	RealPicture(String y) throws InterruptedException { //constructorul cu parametri al acestei clase va apela constructorul clasei parinte (Picture), realizand mostenirea
		super();
	}
	
	@Override
	public void printWidth(){ //metodele din clasa parinte (Picture) vor fi suprascrise, realizandu-se polimorfismul
		System.out.println("Picture width is: "+ width);
	}
	
	@Override
	double getWidth() {
		return width;
	}

	@Override
	void setWidth(double wdt) {
		width = wdt;
	}
	

	@Override
	void printHeight() {
		System.out.println("Picture width is: "+ height);
	}

	@Override
	double getHeight() {
		return height;
	}

	@Override
	void setHeight(double hgt) {
		height = hgt;
	}
	
	RealPicture(double wdt, double hgt, BufferedImage im) throws InterruptedException //constructor cu parametri
	{
		long startTime = System.nanoTime(); //timpul de inceput pentru executia metodei
		width = wdt;
		height = hgt;
		img = im;
		
		long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //timpul de stop pentru executia metodei, folosite pentru a calcula timpul de executie a metodei
		System.out.println("Timp de executie: Image - constructor cu parametri: " + totalTime/1000000000 + " secunde");
	}
	
	void ReadFromFile (String s) throws InterruptedException //metoda folosita pentru citirea imaginii din fisier
	{
		long startTime = System.nanoTime();

		try
		{
			 File input = new File(s); //s este numele fisierului. se creeaza un obiect de tip File ce va fi prelucrat
	         img = ImageIO.read(input); //pentru citirea din fisier se foloseste o metoda din clasa ImageIO
	         width = img.getWidth(); //se pastreaza dimensiunile imaginiiin variabelele aferente
	         height = img.getHeight();			
		}
		
		catch (IOException e) //tratarea exceptiilor - de exemplu, nu exista un fisier cu numele din variabila s
		{
			System.out.println("Fisierul nu xista.");
			System.exit(0);
		}	
		
		long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //calculul timpului de executie a metodei
		System.out.println("Timp de executie: Image - constructor fara parametri: " + totalTime/1000000000 + " secunde");
		
	}
	
	String ReadFile() //metoda folosita pentru citirea de la tastatura a numelui fisierului
	{
		
		long startTime = System.nanoTime();

		String inputFilePath = null; //numele fisierului de intrare
		
		try {				
			InputStreamReader isr = new InputStreamReader(System.in); //se pregateste citirea numelui fisierului de la tastatura
		    BufferedReader br = new BufferedReader(isr); //numele fisierului este preluat din buffer printr-un obiect de tip BufferedReader
		    System.out.println("Introduceti numele/adresa imaginii dorite (extensie .bmp)"); //Fisierul in care se gaseste imaginea trebuie sa aiba extensia .bmp
			inputFilePath = (br.readLine()).toString(); //numele fisierului este preluat in buffer si convertit in tip de date String.
			
			while (!inputFilePath.endsWith(".bmp")) //se verifica extensia numelui fisierului.
			{
				System.out.println("Fisierul nu are extensia potrivita."
						+ " Introduceti un fisier cu extensia .bmp."); // daca nu are extensia dorita, se repeta citirea pana cand numele introdus este corect
				inputFilePath =  (br.readLine()).toString();
			}	
		}
							
		catch (IOException e) //exceptie: nu se poate realiza citirea in mod corect
		{
			System.out.println("Nu s-a realizat citirea numelui/adresei fisierului in mod corect");
		}

		long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //calculul timpului de executie a metodei
		System.out.println("Timp de executie: citire adresa fisier intrare: " + totalTime/1000000000 + " secunde");
		
		
		return inputFilePath;	//metoda va returna numele fisierului 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	String ReadFile(String y) //metoda folosita pentru citirea din srgs
	{
		
		long startTime = System.nanoTime();

		String inputFilePath = y; //numele fisierului de intrare
		
		

		long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //calculul timpului de executie a metodei
		System.out.println("Timp de executie: citire adresa fisier intrare: " + totalTime/1000000000 + " secunde");
		
		
		return inputFilePath;	//metoda va returna numele fisierului 
	}





		


	
}



	