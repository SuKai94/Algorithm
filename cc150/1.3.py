#!/usr/bin/env python
# -*- coding: utf-8 -*-

def remove_duplicate(ss):
    '''
    删除字符串中重复的字符
    不使用额外数组空间
    '''
    if ss == None or ss == "":
        return None
    current = 0
    s = list(ss)
    for i in xrange(len(s)):
        if s[i] != '\0':
            s[current] = s[i]
            current += 1
            for j in xrange(i+1, len(s)):
                if s[i] == s[j]:
                    s[j] = '\0'
    s[current] = '\0'
    return ''.join(s[0:current])

def remove_duplicate_two(ss):
    '''
    使用额外数据空间
    '''
    if ss == None or ss == "":
        return None
    visited = [0]*256
    s = list(ss)
    current = 0
    for i in xrange(len(s)):
        if visited[ord(s[i])] == 0:
            visited[ord(s[i])] = 1
            s[current] = s[i]
            current += 1
    return ''.join(s[0:current])

if __name__ == '__main__':
    print remove_duplicate("aaaa")
    print remove_duplicate_two("aaabb")