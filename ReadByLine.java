import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
 
public class ReadByLine{
   public static void main(String[] args){
      readFromFile("JavaNotes.txt");
   }
 
   private static void readFromFile(String filename){
      LineNumberReader lineNumberReader = null;
      try{
         lineNumberReader = new LineNumberReader(new FileReader(filename)); 
         System.out.println("Line " + lineNumberReader.getLineNumber());
         lineNumberReader.setLineNumber(5);
         System.out.println("Line " + lineNumberReader.getLineNumber());        
         String line = null;
         while ((line = lineNumberReader.readLine()) != null){
            System.out.println("Line " + lineNumberReader.getLineNumber() + ": " + line);
         }
      } 
      catch (Exception ex){
         ex.printStackTrace();
      } finally
      {
         try {
            if (lineNumberReader != null){
               lineNumberReader.close();
            }
         } catch (IOException ex){
            ex.printStackTrace();
         }
      }
   }
}