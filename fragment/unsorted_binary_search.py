#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
非有序数组的二分查找
'''
def swap(A, i, j):
    tmp = A[i]
    A[i] = A[j]
    A[j] = tmp

def quick_sort_v(A, k, left, right):
    if left >= right:
        return left + 1
    i = left + 1
    j = right
    pivot = A[left]
    while True:
        while A[i] < pivot:
            i += 1
            if i == right:
                break
        while A[j] > pivot:
            j -= 1
            if j == left:
                break
        if i >= j:
            break
        swap(A, i, j)
    swap(A, left, j)
    print pivot
    print left, ' ', right, ' ', j
    print A[left : right + 1]
    if k > pivot:
        return quick_sort_v(A, k, j + 1, right)
    elif k < pivot:
        return quick_sort_v(A, k, left, j - 1)
    else:
        return j + 1

#print quick_sort_v([2970, 663, 5480, 4192, 4949, 1, 1387, 4428, 5180, 2761], 5180, 0, 9)
while True:
    (n, k) = (int(x) for x in raw_input().split())
    A = [int(x) for x in raw_input().split()]
    print quick_sort_v(A, k, 0, n - 1)
