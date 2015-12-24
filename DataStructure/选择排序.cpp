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
	int min=0, t;
	for (int i = 0; i < n-1; i++)
	{
		min = i;
		for (int j = i + 1; j < n; j++)
		{
			if (a[j] < a[min])
			{
				min = j;
			}
		}
		if (i != min)
		{
			t = a[i];
			a[i] = a[min];
			a[min] = t;
		}
	}
	printf("Sorted: ");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}