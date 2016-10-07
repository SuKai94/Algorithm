#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
Trie Tree
'''
class Node(object):
    def __init__(self):
        self.count = 0
        self.ch = None
        self.is_word = False
        self.next = [None] * 26

class Trie(object):
    def __init__(self):
        self.root = Node()
        self.word_del = False

    def put(self, word):
        lens = len(word)
        head = self.root
        for i in xrange(lens):
            idx = ord(word[i]) - ord('a')
            if head.next[idx] == None:
                node = Node()
                node.ch = word[i]
                head.next[idx] = node
            head = head.next[idx]
            head.count += 1
        head.is_word = True

    def get(self, word):
        head = self.root
        lens = len(word)
        for i in xrange(lens):
            idx = ord(word[i]) - ord('a')
            if head.next[idx] == None:
                return 0
            else:
                head = head.next[idx]
        return head.count

    def delete(self, word):
        self.word_del = False
        self.root = self.dels(self.root, word, 0)

    def dels(self, x, word, d):
        if x == None:
            return None
        if d == len(word):
            if x.is_word == True:
                x.count -= 1
                self.word_del = True
        else:
            idx = ord(word[d]) - ord('a')
            x.next[idx] = self.dels(x.next[idx], word, d + 1)
            if self.word_del == True:
                x.count -= 1
        if x.is_word == True:
            return x
        for i in xrange(26):
            if x.next[i] != None:
                return x
        return None

trieTree = Trie()
trieTree.put('babaab')
trieTree.put('babbbaaaa')
trieTree.put('abba')
trieTree.put('aaaaabaa')
trieTree.put('babaababb')
#print trieTree.get('bab')
#print trieTree.get('abb')
trieTree.delete('bab')
print trieTree.get('bab')
trieTree.delete('babaababb')
print trieTree.get('babaabaab')
print trieTree.get('babaa')
'''
trieTree.delete('abb')
print trieTree.get('abb')
trieTree.delete('aaaaabaa')
print trieTree.get('a')
print trieTree.get('aaa')
print trieTree.get('abb')
'''
