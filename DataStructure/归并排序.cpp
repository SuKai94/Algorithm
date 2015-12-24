#include<stdio.h>
#include<time.h>
#include<stdlib.h>

#define n 10

void merge(int sr[], int tr[], int s, int m, int t)
{
	int j, k, l;
	// s-[s,m], j-[m+1,t]
	for (j = m + 1, k = s; j <= t && s <= m; k++)
	{
		if (sr[s] < sr[j])
		{
			tr[k] = sr[s++];
		}
		else
		{
			tr[k] = sr[j++];
		}
	}
	if (s <= m)
	{
		for (l = 0; l <= m - s; l++)
		{
			tr[l + k] = sr[s + l];
		}
	}
	if (j <= t)
	{
		for (l = 0; l <= t - j; l++)
		{
			tr[l + k] = sr[j + l];
		}
	}
}

void mSort(int before[], int after[], int s, int t)
{
	int m;
	int after2[n];
	if (s == t)
	{
		after[s] = before[s];
	}
	else
	{
		m = (s + t) / 2;
		mSort(before, after2, s, m);
		mSort(before, after2, m + 1, t);
		merge(after2, after, s, m, t);
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
	
	mSort(a, a, 0, n-1);
	printf("Sorted: ");
	for (int i = 0; i < n; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
}