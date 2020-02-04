class MyThread extends Thread{
	public static void main(String[] args) {
			MyThread thread = new MyThread();
			thread.start();
		}
	@Override
	public void run(){
		System.out.println("times starts");
		try{
			for(int i=0;;i++){
				System.out.print(i + "\r");
				Thread.sleep(1000);
			}
		}catch(Exception e){
				System.out.println("timer not working");
			}
	}	
}