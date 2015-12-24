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
	int t, j;
	for (int i = 1; i < n; i++)
	{
		if (a[i] < a[i - 1])
		{
			t = a[i];
			for (j = i - 1; a[j]>t && j>=0 ; j--)
			{
				a[j + 1] = a[j];
			}
			a[j + 1] = t;
		}
	}

	printf("Sorted: ");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}