#include<stdio.h>
#include<time.h>
#include<stdlib.h>

#define n 10
#define max_digit 2

void radixSort(int a[], int len)
{
	int temp[10][n], order[10] = {0};
	int m = 1, max = 1, p;
	for (int i = 1; i <= max_digit; i++)
	{
		max *= 10;
	}
	while (m < max)
	{
		for (int i = 0; i < n; i++)
		{
			int t = (a[i] / m) % 10;
			temp[t][order[t]++] = a[i];
		}
		p = 0;
		for (int i = 0; i < 10; i++)
		{
			if (order[i] != 0)
			{
				for (int j = 0; j < order[i]; j++)
				{
					a[p++] = temp[i][j];
				}
				order[i] = 0;
			}
		}
		m *= 10;
	}
}

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
	radixSort(a, n);
	printf("Sorted: ");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}