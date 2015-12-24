#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>  
#include<malloc.h>
#include<string.h>

typedef struct node
{
	char data;
	struct node* next;
}Node;

typedef struct stack
{
	Node* top;
	int size;
}Stack;

Stack* initStack();
int push(Stack* stack, char c);
char pop(Stack* stack);

int main()
{
	char str[100];
	Stack* stack = initStack();
	scanf("%s", str);
	int len = strlen(str);
	for (int i = 0; i < len; i++)
	{
		if (str[i] == '(' || str[i] == '{' || str[i] == '[')
		{
			push(stack, str[i]);
		}
		if (str[i] == ')' || str[i] == '}' || str[i] == ']')
		{
			char t = pop(stack);
			//printf("str[i]:%c, pop:%c\n", str[i], t);
			if ((str[i] == ')' && t == '(') || (str[i] == ']' && t == '[') || (str[i] == '}' && t == '{'))
			{
				continue;
			}
			else
			{
				printf("failed!\n");
				return 0;
			}
		}
	}
	printf("success!\n");
	return 0;
}

Stack* initStack()
{
	Stack* stack = (Stack*)malloc(sizeof(Stack));
	if (stack != NULL)
	{
		stack->size = 0;
		stack->top = (Node*)malloc(sizeof(Node));
		stack->top->next = NULL;
	}
	else
	{
		return NULL;
	}
}

int push(Stack* stack, char c)
{
	Node* node = (Node*)malloc(sizeof(Node));
	if (node == NULL)
	{
		return 0;
	}
	node->data = c;
	node->next = stack->top->next;
	stack->top->next = node;
	(stack->size)++;
}

char pop(Stack* stack)
{
	if (stack->size == 0)
	{
		return NULL;
	}
	Node* node = stack->top->next;
	if (node != NULL)
	{
		stack->top->next = node->next;
		char c = node->data;
		free(node);
		return c;
	}
}

