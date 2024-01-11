#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <pthread.h>
#include <unistd.h>
#define NEW_WINDOW 1
void* countDown() {
    for (int i = 5; i > 0; i--) {
        printf("%d...\n", i);
        sleep(1);
    }
    MessageBox(NULL, "Time's up!", "Time's up", MB_OK);

    return NULL;
}


int clockRun() {
    pthread_t thread_id;
    printf("Starting countdown...\n");
    pthread_create(&thread_id, NULL, countDown, NULL);
    // pthread_join(thread_id, NULL); // for wait 
    return 0;
}

int main()
{
    int option = 0;
    while (option != -1)
    {
        printf("Select option: %d \n ", option);
        scanf("%d", &option);
        printf("option: %d \n ", option);
        if (option == NEW_WINDOW)
            clockRun();
    }
    system("pause");
    return 0;
}
