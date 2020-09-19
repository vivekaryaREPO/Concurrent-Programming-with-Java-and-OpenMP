#include<stdio.h>
#include<omp.h>
int main(int *argc, char *argv[])
{
	//if A is m*n then B should be n*p only, and then C will be m*p
   int m=800,n=800,o=800,p=800,i=0,j=0,k=0;
   int matrixA[800][800];	  	   					   
   int matrixB[800][800];				   
   int matrixC[m][p];
   double startTime,endTime;
   
    for(i=0;i<m;i++)
    {
    for(j=0;j<n;j++)
	{
		matrixA[i][j]=1;
	}
	}
     
    for(i=0;i<o;i++)
    {
    for(j=0;j<p;j++)
	{
		matrixB[i][j]=1;
	}
	}	 
    printf("\n");
   printf("Matrix A size is %d X %d\nMatrix B size is %d X %d\n",m,n,o,p); 
   startTime=omp_get_wtime();
   for(i=0;i<m;i++)
   {
	   for(j=0;j<p;j++)
	   {
		   matrixC[i][j]=0;
		    //since number of cols in A is equal to number of rows in B, k value should be any of those two value,
		   //it doesn't matter as both are equal
		   for(k=0;k<o;k++)
		   {
			   matrixC[i][j]+=matrixA[i][k]*matrixB[k][j];
		   }
	   }
   }
   endTime=omp_get_wtime();
   
   printf("\n");
printf("Matrix multiplication using SEQUENTIAL APPROACH completed in %g \n",endTime - startTime);
   
}
