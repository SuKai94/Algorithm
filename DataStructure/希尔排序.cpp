#include<stdio.h>
#include<time.h>
#include<stdlib.h>

#define n 10

int main()
{
	int a[n];
	srand((unsigned int)time(NULL));
	printf("Init: ");
	for (int i = 0; i < n; i++)
	{
		a[i] = rand() % 100;
		printf("%d ", a[i]);
	}
	printf("\n");
	int t;
	// n = 2
	if (n==2)
	{
		if (a[0] > a[1])
		{
			t = a[0];
			a[0] = a[1];
			a[1] = t;
		}
	}
	else
	{
		int crement = n, j;
		while (crement > 1)
		{
			crement = crement / 3 + 1;
			for (int i = crement; i < n; i++)
			{
				if (a[i] < a[i - crement])
				{
					t = a[i];
					for (j = i - crement; j >= 0 && a[j] > t; j-=crement)
					{
						a[j + crement] = a[j];
					}
					a[j + crement] = t;
				}
			}
			//crement = crement / 3 + 1;
		}
	}
	printf("Sorted: ");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}