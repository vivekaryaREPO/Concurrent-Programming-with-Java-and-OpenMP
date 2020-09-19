package sleepingBarberConcurrent;
import java.util.Random;
import java.util.Queue;
class BarberLogic extends Thread {
	int mean=20,standardDeviation=10;
	CustomerChairs customerChairs;
	BarberChairs barberChairs;
	Queue<CustomerLogic> customerQueue;
	int barberNo=0;	
	public BarberLogic(CustomerChairs customerchairs,BarberChairs barberchairs,Queue<CustomerLogic> customerqueue,int i)
	{
		this.customerChairs=customerchairs;
		this.barberChairs=barberchairs;
		this.customerQueue=customerqueue;
		this.barberNo=i+1;
	}
	
	public void run()
	{
		while(true){
			synchronized(this.barberChairs) {
	    if(customerQueue.size()>0)
	    {
	    	if(barberChairs.getAvailableBarberChairs()>0)
	    	{
	    		CustomerLogic cs=this.customerQueue.poll();

	    			System.out.println("barber "+this.barberNo+" starts serving customer "+cs.customerNo);
	    			cs.start();
		    		this.barberChairs.customerTakingHaircut();	    		
	    		
	    		try
	    		{
	    			Thread.sleep(new Random().nextInt(50)*mean*standardDeviation);
	    		}
	    		catch(Exception e)
	    		{
	    			System.out.println(e.getMessage());
	    		}
	    		
	    		this.barberChairs.CustomerPaysAndExit();
	    		System.out.println("Customer "+cs.customerNo+" pays and leaves from the exit door");
	    	    
	    		
	    	}
	    }
	    else
	    {
	    	System.out.println("No customer, so barber "+this.barberNo+" is asleep!! ");
			try
    		{
    			Thread.sleep(500);
    		}
    		catch(Exception e)
    		{
    			System.out.println(e.getMessage());
    		}	    	
	    	
	    }

		}
		try
		{
			Thread.sleep(50);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
}

