#!/usr/bin/env python
# -*- coding: utf-8 -*-

def check_unique(ss):
    '''
    检查字符串是否有重复字符
    '''
    visited = [0]*8
    s = list(ss)
    ok = True
    for i in xrange(len(s)):
        idx = ord(s[i])/32
        shift = ord(s[i])%32
        if (1<<shift) & visited[idx]:
            ok = False
            break
        else:
            visited[idx] |= (1<<shift)
    return ok

if __name__ == '__main__':
    print check_unique("abc")