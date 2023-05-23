import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class bib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        System.out.println("------------Welcome to BibCreator!------------\n");
		        //We start by creating scanners and printwriters to read and create files in order to see if there is
		        //a problem with the latex files or creating new files
		        Scanner kb=new Scanner(System.in);
		        Scanner[] sc=new Scanner[10];
		        int i=1;
		        String FileFinder="";
		        try {
		            for (i = 1; i < 11;i++)
		                sc[i-1] = new Scanner(new FileInputStream("Latex" + i + ".bib"));
		        }
		        catch(FileNotFoundException e){
		            System.out.println("Could not open input file Latex"+i+".bib for reading. \nPlease check if file exists! \nProgram will terminate after closing any opened files.");
		            System.exit(0);
		        }
		        PrintWriter[] pw1=new PrintWriter[10];
		        PrintWriter[] pw2=new PrintWriter[10];
		        PrintWriter[] pw3=new PrintWriter[10];
		        try{
		            for (i=1;i<11;i++) {
		                FileFinder="IEEE";
		                pw1[i-1] = new PrintWriter(new FileOutputStream("IEEE" + i + ".json",true));
		                FileFinder="ACM";
		                pw2[i-1] = new PrintWriter(new FileOutputStream("ACM" + i + ".json",true
		                ));
		                FileFinder="NJ";
		                pw3[i-1] = new PrintWriter(new FileOutputStream("NJ" + i + ".json",true));
		                pw1[i-1].close();
		                pw2[i-1].close();
		                pw3[i-1].close();
		            }
		        }
		        catch (FileNotFoundException e){
		            System.out.println("Could not create output file "+FileFinder+i+".json\nWill now terminate!");
		            System.exit(0);
		        }
		        //We then call the main processing function for all 11 latex files
		        for(i=1;i<11;i++) {
		            FileValidation.processFilesForValidation(i);
		        }
		        System.out.println("A total of "+FileValidation.count+" files were invalid. There are only "+(10-FileValidation.count)+" valid files processed");
		        BufferedReader br=null;
		        String line=null;
		        //Here we call and handle the function that scans and prints the files to review
		        try{
		            FileValidation.reviewFile(br,line,kb);
		        } catch(FileNotFoundException e){
		            System.out.println("Could not open input file. File does not exist!");
		            try{
		                FileValidation.reviewFile(br,line,kb);
		            }
		            catch(FileNotFoundException ex){
		                System.out.println("Could not open input file. File does not exist!");
		                System.out.println("Will now terminate program!");
		                System.exit(0);
		            }
		            catch (IOException ex){
		                System.out.println("IO Exception occurred! Will now terminate program!");
		                System.exit(0);
		            }
		        } catch (IOException e){
		            System.out.println("IO Exception occurred! Will now terminate program!");
		            System.exit(0);
		        }

	}

}
