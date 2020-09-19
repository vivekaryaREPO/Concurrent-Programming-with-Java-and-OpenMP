package sleepingBarberConcurrent;

    class BarberChairs {
	int noOfCustomerChairs;
	int limit;
	public BarberChairs(int n)
	{
		this.noOfCustomerChairs=n;
		this.limit=n;
	}
	
	public void customerTakingHaircut()
	{
		if(this.noOfCustomerChairs>0)
		{
		this.noOfCustomerChairs=this.noOfCustomerChairs-1;
		}

	}
	
	public void CustomerPaysAndExit()
	{
		if(this.noOfCustomerChairs<=this.limit)
		{
		this.noOfCustomerChairs=this.noOfCustomerChairs+1;
		}

	}
	
	public int getAvailableBarberChairs()
	{
		return this.noOfCustomerChairs;
	}

}
