#include<stdio.h>
#include<time.h>
#include<stdlib.h>

#define n 10

void swap(int a[], int i, int j)
{
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
}

int partition(int a[], int low, int high)
{
	int key = a[low];
	while (low < high)
	{
		while (high > low && a[high] >= key)
		{
			high--;
		}
		swap(a, low, high);
		while (low < high && a[low] <= key)
		{
			low++;
		}
		swap(a, low, high);
	}
	return low;
}

void qSort(int a[], int low, int high)
{
	int pivot;
	if (low < high)
	{
		pivot = partition(a, low, high);
		qSort(a, low, pivot - 1);
		qSort(a, pivot + 1, high);
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
	
	qSort(a, 0, n-1);
	printf("Sorted: ");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}