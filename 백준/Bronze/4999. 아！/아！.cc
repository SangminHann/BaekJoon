#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    char a[1000], b[1000];
    scanf("%s %s", a, b);
    int lenA = strlen(a);
    int lenB = strlen(b);
    if (lenA < lenB) {
        printf("no\n");
        return 0;
    } 
    printf("go\n");
}