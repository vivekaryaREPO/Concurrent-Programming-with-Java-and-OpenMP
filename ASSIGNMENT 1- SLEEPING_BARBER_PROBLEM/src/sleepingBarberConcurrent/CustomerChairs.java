package sleepingBarberConcurrent;

class CustomerChairs {
	int noOfCustomerChairs;
	int limit;
	public CustomerChairs(int n)
	{
		this.noOfCustomerChairs=n;
		this.limit=n;
	}
	
	public void customerSatDown()
	{
		if(this.noOfCustomerChairs>0)
		{
		this.noOfCustomerChairs=this.noOfCustomerChairs-1;
		}

	}
	
	public void customerGotUp()
	{
		if(this.noOfCustomerChairs<=this.limit)
		{
		this.noOfCustomerChairs=this.noOfCustomerChairs+1;
		}
	}
	
	public int getAvailableCustomerChairs()
	{
		return this.noOfCustomerChairs;
	}

}
