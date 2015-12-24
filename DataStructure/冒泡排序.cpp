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
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n - i - 1; j++)
		{
			if (a[j]>a[j + 1])
			{
				t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t;
			}
		}
	}
	printf("Sorted: ");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}