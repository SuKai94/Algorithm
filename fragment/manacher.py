#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
Manacher Algorithms: O(n)求字符串的最长回文子串
'''
def manacher(strs):
    t_str = [0] * (len(strs) * 2 + 2)
    t_str[0] = '$'
    t_str[1] = '#'
    idx = 2
    for i in xrange(len(strs)):
        t_str[idx] = strs[i]
        t_str[idx + 1] = '#'
        idx += 2
    p = [0] * len(t_str)
    id = 0
    mx = id + p[id]
    max_p = float('-inf')
    max_idx = 0
    for i in xrange(1, len(t_str)):
        p[i] = 1 if mx < i else min(p[2 * id - i], mx - i)
        while i - p[i] >= 0 and i + p[i] < len(t_str) and t_str[i + p[i]] == t_str[i - p[i]]:
            p[i] += 1
        if i + p[i] > mx:
            mx = i + p[i]
            id = i
        if p[i] > max_p:
            max_p = p[i]
            max_idx = i
    print max_p - 1
    res = [tmp for tmp in t_str[max_idx - p[max_idx] + 1: max_idx + p[max_idx] - 1] if tmp != '#']
    print res

manacher('12212321')
