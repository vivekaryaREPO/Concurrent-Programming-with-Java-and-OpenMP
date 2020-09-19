package sleepingBarberConcurrent;
import java.lang.Thread;
import java.util.concurrent.locks.ReentrantLock;
class CustomerLogic extends Thread {
	 CustomerChairs customerChairs;
	 int customerNo=0;
	 private static ReentrantLock lock=new ReentrantLock(); 
     public CustomerLogic(CustomerChairs customerchairs,int custNo)
     {
    	 
    	this.customerChairs=customerchairs;
    	this.customerNo=custNo;
    	
     }
     
     public void run()
     {
    	 lock.lock();
    	this.customerChairs.customerGotUp();
    	lock.unlock();
     }
}
