import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Load {
	
	public static void main(String[] args)throws IOException {
		   
        // FileWriter fw=new FileWriter("D:\\filereader.txt");    
        // fw.write("Welcome to javaTpoint.");
         FileReader fr=new FileReader("D:\\filereader.txt");    
         int i;    
         while((i=fr.read())!=-1)    
         System.out.print((char)i);
         fr.close(); 

	}

}
