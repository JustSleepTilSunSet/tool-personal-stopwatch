#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define NEW_WINDOW 1
int main()
{
    int option = 0;
    while (option != -1)
    {
        scanf("%d", &option);
        printf("option: %d \n ", option);
        if (option == NEW_WINDOW)
        {
            MessageBox(NULL, "Hello, World!", "My Program", MB_OK);
        }
    }
    system("pause");
    return 0;
}
