import java.io.*; 
  
public class CountingNumber 
{ 
    public static void main(String[] args) throws IOException 
    { 
        File file = new File("C:\\javaprograms\\JavaFileInput.txt"); 
        FileInputStream fileStream = new FileInputStream(file); 
        InputStreamReader input = new InputStreamReader(fileStream); 
        BufferedReader reader = new BufferedReader(input); 
          
        String s; 
          
        int countWord = 0; 
        int sentenceCount = 0; 
        int characterCount = 0; 
        int paragraphCount = 1;  
           
        while((s = reader.readLine()) != null) 
        { 
            if(s.equals("")) 
            { 
                paragraphCount++; 
            } 
            if(!(s.equals(""))) 
            { 
                  
                characterCount += s.length(); 
                  
                String[] wordList = s.split("\\s+"); 
                  
                countWord += wordList.length;  
                   
                String[] sentenceList = s.split("[!?.:]+"); 
                  
                sentenceCount += sentenceList.length; 
            } 
        } 
          
        System.out.println("word Count = " + countWord); 
        System.out.println("line Count = " + sentenceCount); 
        System.out.println("character Count = " + characterCount); 
        System.out.println("Number of paragraphs = " + paragraphCount); 
    } 
}