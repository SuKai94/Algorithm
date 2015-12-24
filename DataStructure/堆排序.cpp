#include<stdio.h>
#include<time.h>
#include<stdlib.h>

#define n 10

void heapAdjust(int a[], int s, int m)
{
	int temp = a[s];
	for (int j = 2 * s; j <= m; j *= 2)
	{
		if (j < m && a[j] < a[j + 1])
		{
			j++;
		}
		if (temp > a[j])
		{
			break;
		}
		a[s] = a[j];
		s = j;
	}
	a[s] = temp;
}

int main()
{
	int a[n+1];
	srand((unsigned int)time(NULL));
	printf("Init: ");
	a[0] = 0;
	for (int i = 1; i <= n; i++)
	{
		a[i] = rand() % 100;
		printf("%d ", a[i]);
	}
	printf("\n");
	
	// a[0]=0
	for (int i = n/2; i > 0; i--)
	{
		heapAdjust(a, i, n);
	}
	int t;
	for (int i = n; i > 1; i--)
	{
		t = a[i];
		a[i] = a[1];
		a[1] = t;
		heapAdjust(a, 1, i-1);
	}

	printf("Sorted: ");
	for (int i = 1; i <= n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}