#!/usr/bin/env python
# -*- coding: utf-8 -*-

def is_anagrams_one(s, t):
    '''
    变位词(anagrams)指的是组成两个单词的字符相同，但位置不同的单词
    判断s, t是否为变位词
    先排序，后判断
    '''
    if len(s) != len(t):
        return False
    sort_s = sorted(s)
    sort_t = sorted(t)
    return sort_s == sort_t


def is_anagrams_two(s, t):
    '''
    变位词(anagrams)指的是组成两个单词的字符相同，但位置不同的单词
    判断s, t是否为变位词
    利用计数数组
    '''
    if len(s) != len(t):
        return False
    counts =  [0]*256
    for i in xrange(len(s)):
        counts[ord(s[i])] += 1
        counts[ord(t[i])] -= 1
    for c in counts:
        if c != 0:
            return False
    return True

if __name__ == '__main__':
    print is_anagrams_one("accabaa", "acaabca")
    print is_anagrams_two("accabaa", "acaabca")