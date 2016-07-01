#!/usr/bin/env python
# -*- coding: utf-8 -*-

def largest_area(histogram):
    '''
    求柱状图中的最大矩形面积
    '''
    histogram.append(-1)
    index = 0
    max_area = 0
    stack = []
    while index < len(histogram):
        if len(stack) == 0 or histogram[stack[-1]] <= histogram[index]:
            stack.append(index)
            index += 1
        else:
            top = stack.pop()
            area = 0
            if len(stack) == 0:
                area = histogram[top]*index
            else:
                area = histogram[top]*(index-stack[-1]-1)
            if area > max_area:
                max_area = area
    return max_area

if __name__ == '__main__':
    print largest_area([2,1,5,6,2,3])