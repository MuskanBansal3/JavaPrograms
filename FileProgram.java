import java.io.*;


class CopyDataThread implements Runnable{
	public void run(){
		boolean bool=true;
		try{
			File sourcefile = new File("source.txt");
			File targetfile = new File("target.txt");
			char[] in = new char[200];
			int i=0;
			FileReader fr = new FileReader(sourcefile);
			FileWriter fw = new FileWriter(targetfile);
			fr.read(in);

			do{
			for (int j=i; j<i+10 ;j++ ) {
				fw.write(in[j]);
				fw.flush();
				if(in[j]=='\0'){
					bool=false;
					break;
				}
			}
				System.out.println("10 characters copied "); 
				i+=10;
			}while(bool);
		
		
		fr.close();
		fw.close();
		} catch(IOException e) {System.out.println("File handling error"); }
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println("Some error with sleep");
		}
	}
}



class FileProgram{
	public static void main(String[] args) {
		CopyDataThread obj = new CopyDataThread();
		Thread t1 = new Thread(obj);
		t1.run();

	}
	
}