package sleepingBarberConcurrent;
import java.util.LinkedList;
import java.util.Random;
import java.util.*;
import java.util.concurrent.*;
import java.lang.Thread;
public class TheBestBarbersSalon {
	public static void main(String[] args)
	{
		int mean=10,standardDeviation=5,customerCount=0;
		
		
		@SuppressWarnings("resource")
		Scanner val=new Scanner(System.in);
		System.out.println("Enter the number of customer chairs at the customer waiting area: ");
		int customerChairLimit=val.nextInt();
		CustomerChairs customerChairs=new CustomerChairs(customerChairLimit);
		System.out.println("Enter the number of barbers at service: ");
		int barberChairLimit=val.nextInt();
		BarberChairs barberChairs=new BarberChairs(barberChairLimit);
		ExecutorService barbersReady = Executors.newFixedThreadPool(barberChairLimit);
		Queue<CustomerLogic> customerQueue=new LinkedList<CustomerLogic>();
		System.out.println("HEY THERE, WE ARE OPEN!! !! !! !! ");
		for(int i=0;i<barberChairLimit;i++)
		{
			barbersReady.execute(new BarberLogic(customerChairs,barberChairs,customerQueue,i));
		}		
		while(true)
		{
			try
			{
				Thread.sleep(new Random().nextInt(50)*mean*standardDeviation);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			if(customerQueue.size()<customerChairLimit)
			{
				customerCount++;
				if(customerCount==1)
				{
				System.out.println("Customer "+customerCount+ " walks in and awakes the barber");
				customerQueue.add(new CustomerLogic(customerChairs,customerCount));
				}
				else
				{
					System.out.println("Customer "+customerCount+ " comes in and waits at the waiting area");
					customerQueue.add(new CustomerLogic(customerChairs,customerCount));
				}
			}
			else
			{
				customerCount++;
				CustomerLogic cl=new CustomerLogic(customerChairs,customerCount);
				System.out.println("No vacancy so customer "+cl.customerNo+" leaves");
			}
		}
	}

}
